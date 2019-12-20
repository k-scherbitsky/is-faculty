package io.isfaculty.service.impl

import io.isfaculty.converter.TeacherConverter
import io.isfaculty.dao.*
import io.isfaculty.dto.FullTeacher
import io.isfaculty.dto.Teacher
import io.isfaculty.dto.searchCriteria.FullNameSearch
import io.isfaculty.dto.searchCriteria.TeacherSearchCriteria
import io.isfaculty.model.AddressEntity
import io.isfaculty.model.DepartmentEntity
import io.isfaculty.model.HumanEntity
import io.isfaculty.model.TeacherEntity
import io.isfaculty.service.TeacherService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.text.SimpleDateFormat
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.persistence.criteria.Expression
import javax.persistence.criteria.Join
import javax.persistence.criteria.JoinType

@Service
@Transactional
class TeacherServiceImpl  @Autowired constructor(
        private val humanRepository: HumanRepository,
        private val studentRepository: StudentRepository,
        private val groupRepository: GroupRepository,
        private val teacherConverter: TeacherConverter,
        private val facultyRepository: FacultyRepository,
        private val studyFormRepository: StudyFormRepository,
        private val teacherTypeRepository: TeacherTypeRepository,
        private val departmentRepository: DepartmentRepository,
        private val teacherRepository: TeacherRepository

) : TeacherService {


    @PersistenceContext
    private lateinit var entityManager: EntityManager

    override fun createStudent(teacher: Teacher) {
        val entity = TeacherEntity()

        var humanEntity = HumanEntity()
        humanEntity.firstName = teacher.firstName
        humanEntity.lastName = teacher.lastName
        humanEntity.middleName = teacher.middleName
        humanEntity.birthDate = SimpleDateFormat("yyyy-MM-dd").parse(teacher.birthDate)
        humanEntity.email = teacher.email
        humanEntity.phoneNumber = teacher.phoneNumber
        humanEntity.sex = teacher.sex
        humanEntity = humanRepository.save(humanEntity)

        val address = AddressEntity()
        address.country = teacher.address?.country
        address.city = teacher.address?.city
        address.street = teacher.address?.street
        address.house = teacher.address?.house
        address.building = teacher.address?.building
        address.flat = teacher.address?.flat
        address.legalAddress = true
        address.humanEntity = humanEntity

        val addresses = ArrayList<AddressEntity>()
        addresses.add(address)
        humanEntity.addressList = addresses

        entity.humanEntity = humanEntity
        entity.teacherTypeEntity = teacherTypeRepository.findById(teacher.teacherTypeId!!).get()

        val deptsIds: List<Int?> = teacher.departments!!.replace(" ", "").split(",").map { it.toIntOrNull() }
        entity.teachersDepartment = departmentRepository.findByIdDepartmentIn(deptsIds)


        teacherRepository.save(entity)
    }

    override fun getFullTeacher(id: Int): FullTeacher? {

        val entity = teacherRepository.findByIdOrNull(id)

        return teacherConverter.convertFull(entity)
    }

    override fun search(searchCriteria: TeacherSearchCriteria): List<FullTeacher?> {
        val builder = entityManager.criteriaBuilder
        val criteriaQuery = builder.createQuery(TeacherEntity::class.java)
        val root = criteriaQuery.from(TeacherEntity::class.java)
        var predicate = builder.conjunction()

        if (!searchCriteria.teacherTypes.isNullOrEmpty()) {
            val expression: Expression<String> = root.get<Any>("teacherTypeEntity").get("idTeacherType")
            val teacherTypes = searchCriteria.teacherTypes!!.replace(" ", "").split(",").map { it.toIntOrNull() }
            predicate = builder.and(predicate, expression.`in`(teacherTypes))
        }

        if (!searchCriteria.department.isNullOrEmpty()) {
            val join: Join<TeacherEntity, DepartmentEntity> = root.join<TeacherEntity, DepartmentEntity>("teachersDepartment", JoinType.INNER)
            val department = searchCriteria.department!!.replace(" ", "").split(",").map { it.toIntOrNull() }
            predicate = builder.and(predicate, join.get<String>("idDepartment").`in`(department))
        }

        criteriaQuery.where(predicate)
        val items: List<TeacherEntity> = entityManager.createQuery(criteriaQuery).resultList

        return items.map{ teacherConverter.convertFull(it) }
    }

    override fun searchByFullName(fullNameSearch: FullNameSearch): List<FullTeacher?> {
        val teachers = teacherRepository.findByFullName(fullNameSearch.firstName, fullNameSearch.lastName, fullNameSearch.middleName)

        return teachers.map { teacherConverter.convertFull(it) }
    }
}