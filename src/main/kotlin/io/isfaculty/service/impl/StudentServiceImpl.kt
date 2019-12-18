package io.isfaculty.service.impl

import io.isfaculty.converter.StudentConverter
import io.isfaculty.dao.*
import io.isfaculty.dto.Expelled
import io.isfaculty.dto.FullStudent
import io.isfaculty.dto.ScienceConf
import io.isfaculty.dto.Student
import io.isfaculty.dto.searchCriteria.StudentSearchCriteria
import io.isfaculty.model.*
import io.isfaculty.service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
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
        private val facultyRepository: FacultyRepository,
        private val studyFormRepository: StudyFormRepository,
        private val scienceConfRepository: ScienceConfRepository,
        private val expelledRepository: ExpelledRepository
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
        humanEntity.sex = "m"
        humanEntity = humanRepository.save(humanEntity)

        val studentEntity = StudentEntity()
        studentEntity.humanEntity = humanEntity
        studentEntity.recordBook = student.recordBook
        studentEntity.groupEntity = groupRepository.findByName(student.group.toString())
        studentEntity.admissionDate = SimpleDateFormat("yyyy-MM-dd").parse(student.admissionDate)
        studentEntity.studyFormEntity = studyFormRepository.findByName(student.studyForm.toString())
        studentEntity.hasChildren = student.hasChildren
        studentEntity.courseNumber = 4
        studentRepository.save(studentEntity)
    }

    override fun search(searchCriteria: StudentSearchCriteria): List<Student> {

        val builder = entityManager.criteriaBuilder
        val criteriaQuery = builder.createQuery(StudentEntity::class.java)
        val root = criteriaQuery.from(StudentEntity::class.java)
        var predicate = builder.conjunction()

        if (!searchCriteria.group.isNullOrEmpty()) {
            val expression: Expression<String> = root.get<Any>("groupEntity").get("name")
            val groups = searchCriteria.group!!.split(",")
            predicate = builder.and(predicate, expression.`in`(groups))
        }

        if (!searchCriteria.faculty.isNullOrEmpty()) {
            val expression: Expression<String> = root.get<Any>("groupEntity").get<Any>("departmentEntity").get<Any>("facultyEntity").get("name")
            val faculties = searchCriteria.faculty!!.split(",")
            predicate = builder.and(predicate, expression.`in`(faculties))
        }

        if (!searchCriteria.department.isNullOrEmpty()) {
            val expression: Expression<String> = root.get<Any>("groupEntity").get<Any>("departmentEntity").get("name")
            predicate = builder.and(predicate, builder.like(builder.lower(expression), "%${searchCriteria.department!!.toLowerCase()}%"))
        }

        if (!searchCriteria.sex.isNullOrEmpty()) {
            val expression: Expression<String> = root.get<Any>("humanEntity").get("sex")
            predicate = builder.and(predicate, builder.like(builder.lower(expression), "%${searchCriteria.sex!!.toLowerCase()}%"))
        }

        if (!searchCriteria.course.isNullOrEmpty()) {
            val expression: Expression<String> = root.get("courseNumber")
            val courses = searchCriteria.course!!.replace(" ", "").split(",").map { it.toIntOrNull() }
            predicate = builder.and(predicate, expression.`in`(courses))
        }

        if (searchCriteria.hasChildren != null) {
            val expression: Expression<String> = root.get("hasChildren")
            predicate = builder.and(predicate, builder.equal(expression, searchCriteria.hasChildren))
        }

        criteriaQuery.where(predicate)
        val items: List<StudentEntity> = entityManager.createQuery(criteriaQuery).resultList

        return items.map { studentConverter.convert(it) }
    }

    override fun getConf(prize: Boolean): List<ScienceConf> {

        return if (!prize) {
            scienceConfRepository.findAll().map { studentConverter.convertConf(it) }
        } else {
            scienceConfRepository.findByPrize().map { studentConverter.convertConf(it) }
        }
    }

    override fun getHeadmans(group: String): List<Student> {

        val groups = group.replace(" ", "").split(",").map { it.toIntOrNull() }
        val groupEntities: List<GroupEntity> = groupRepository.findByIdGroupIn(groups)

        return groupEntities.map { it.headmanEntity }.map { studentConverter.convert(it) }
    }

    override fun setSearchCriteria(): StudentSearchCriteria {
        val criteria = StudentSearchCriteria();

        val faculties: List<FacultyEntity> = facultyRepository.findAll()
        val groupEntity: List<GroupEntity> = groupRepository.findAll();
        criteria.facultyList = faculties.map { it.name.toString() }
        criteria.groupList = groupEntity.map { it.name.toString() }

        return criteria
    }

    override fun getFullStudent(id: Int): FullStudent? {

        val student: StudentEntity? = studentRepository.findByIdOrNull(id)

        return studentConverter.convertFull(student)
    }

    override fun getExpelleds(expelled: Boolean): List<Expelled> {
        val expelleds = expelledRepository.findByByChoice(expelled)

        return expelleds.map { studentConverter.convertExpelled(it) }
    }
}