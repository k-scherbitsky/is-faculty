package io.isfaculty.service.impl

import io.isfaculty.converter.GradeConverter
import io.isfaculty.dao.*
import io.isfaculty.dto.searchCriteria.ExamTestSerach
import io.isfaculty.dto.ExamTestSerachResponse
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
        private val groupRepository: GroupRepository,
        private val gradeRepository: GradeRepository,
        private val gradeConverter: GradeConverter
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

    override fun examOrTest(examTestSerach: ExamTestSerach): List<ExamTestSerachResponse?> {
        val groupsIds: List<Int?>? = examTestSerach.groupIds?.replace(" ", "")?.split(",")?.map { it.toIntOrNull() }
        val groupsEntities = groupRepository.findByIdGroupIn(groupsIds)

        val grades = gradeRepository.findAllByStudyPlanEntity_IdStudyPlanAndGrade(examTestSerach.studyPlanId!!, examTestSerach.mark!!)

        val gradesResult = ArrayList<GradeEntity>()

        for(grade in grades) {
            if(groupsEntities.contains(grade.studentEntity?.groupEntity)) {
                gradesResult.add(grade)
            }
        }

        return gradesResult.map { gradeConverter.convert(it) }
    }
}