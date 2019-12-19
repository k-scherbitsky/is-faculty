package io.isfaculty.service.impl

import io.isfaculty.dao.GradeRepository
import io.isfaculty.dao.StudentRepository
import io.isfaculty.dao.StudyPlanRepository
import io.isfaculty.dao.TeacherRepository
import io.isfaculty.dto.GradeRequest
import io.isfaculty.model.GradeEntity
import io.isfaculty.service.GradeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional
class GradeServiceImpl  @Autowired constructor(
        private val studyPlanRepository: StudyPlanRepository,
        private val studentRepository: StudentRepository,
        private val teacherRepository: TeacherRepository,
        private val gradeRepository: GradeRepository
) : GradeService {

    override fun addMark(gradeRequest: GradeRequest) {
        val entity = GradeEntity()

        entity.studentEntity = studentRepository.findById(gradeRequest.studentId!!).get()
        entity.teacherEntity = teacherRepository.findById(gradeRequest.teacherId!!).get()
        entity.studyPlanEntity = studyPlanRepository.findById(gradeRequest.studyPlanId!!).get()
        entity.grade = gradeRequest.grade
        entity.createdDate = Date()

        gradeRepository.save(entity)
    }
}