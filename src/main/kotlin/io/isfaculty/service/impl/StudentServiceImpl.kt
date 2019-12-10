package io.isfaculty.service.impl

import io.isfaculty.converter.StudentConverter
import io.isfaculty.dao.GroupRepository
import io.isfaculty.dao.HumanRepository
import io.isfaculty.dao.StudentRepository
import io.isfaculty.dao.StudyFormRepository
import io.isfaculty.dto.Student
import io.isfaculty.dto.StudentSearchCriteria
import io.isfaculty.model.HumanEntity
import io.isfaculty.model.StudentEntity
import io.isfaculty.service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.text.SimpleDateFormat
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.persistence.criteria.Expression


@Service
@Transactional
class StudentServiceImpl @Autowired constructor(
        private val humanRepository: HumanRepository,
        private val studentRepository: StudentRepository,
        private val groupRepository: GroupRepository,
        private val studentConverter: StudentConverter,
        private val studyFormRepository: StudyFormRepository
) : StudentService {

    @PersistenceContext
    private lateinit var entityManager: EntityManager

    override fun createStudent(student: Student) {

        var humanEntity = HumanEntity()
        humanEntity.firstName = student.firstName
        humanEntity.lastName = student.lastName
        humanEntity.middleName = student.middleName
        humanEntity.birthDate = SimpleDateFormat("yyyy-MM-dd").parse(student.birthDate)
        humanEntity.email = student.email
        humanEntity.phoneNumber = student.phoneNumber
        humanEntity = humanRepository.save(humanEntity)

        val studentEntity = StudentEntity()
        studentEntity.humanEntity = humanEntity
        studentEntity.idRecordBook = student.recordBook
        studentEntity.groupEntity = groupRepository.findByName(student.group.toString())
        studentEntity.admissionDate = SimpleDateFormat("yyyy-MM-dd").parse(student.admissionDate)
        studentEntity.studyFormEntity = studyFormRepository.findByName(student.studyForm.toString())
        studentEntity.hasChildren = student.hasChildren
        studentRepository.save(studentEntity)
    }

    override fun search(searchCriteria: StudentSearchCriteria): List<Student> {

        val builder = entityManager.criteriaBuilder
        val criteriaQuery = builder.createQuery(StudentEntity::class.java)
        val root = criteriaQuery.from(StudentEntity::class.java)
        var predicate = builder.conjunction()

        if (!searchCriteria.group.isNullOrEmpty()) {
            val expression: Expression<String> = root.get<Any>("groupEntity").get("name")
            predicate = builder.and(predicate, builder.like(builder.lower(expression), "%${searchCriteria.group!!.toLowerCase()}%"))
        }

        if (!searchCriteria.department.isNullOrEmpty()) {
            val expression: Expression<String> = root.get<Any>("groupEntity").get<Any>("departmentEntity").get("name")
            predicate = builder.and(predicate, builder.like(builder.lower(expression), "%${searchCriteria.department!!.toLowerCase()}%"))
        }

        if (!searchCriteria.sex.isNullOrEmpty()) {
            val expression: Expression<String> = root.get<Any>("humanEntity").get("sex")
            predicate = builder.and(predicate, builder.like(builder.lower(expression), "%${searchCriteria.sex!!.toLowerCase()}%"))
        }

        if (searchCriteria.course in 1..6) {
            val expression: Expression<String> = root.get("courseNumber")
            predicate = builder.and(predicate, builder.equal(expression, searchCriteria.course))
        }

        if (searchCriteria.hasChildren != null) {
            val expression: Expression<String> = root.get("hasChildren")
            predicate = builder.and(predicate, builder.equal(expression, searchCriteria.hasChildren))
        }

        criteriaQuery.where(predicate)
        val items: List<StudentEntity> = entityManager.createQuery(criteriaQuery).resultList

        return items.map { studentConverter.convert(it) }
    }
}