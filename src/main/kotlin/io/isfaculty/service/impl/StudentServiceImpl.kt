package io.isfaculty.service.impl

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
import java.util.*

@Service
@Transactional
class StudentServiceImpl @Autowired constructor(
        private val humanRepository: HumanRepository,
        private val studentRepository: StudentRepository,
        private val groupRepository: GroupRepository,
        private val studyFormRepository: StudyFormRepository
) : StudentService {


    override fun createStudent(student: Student) {

        var humanEntity = HumanEntity();
        humanEntity.firstName = student.firstName;
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

    override fun search(searchCriteria: StudentSearchCriteria): Student {

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}