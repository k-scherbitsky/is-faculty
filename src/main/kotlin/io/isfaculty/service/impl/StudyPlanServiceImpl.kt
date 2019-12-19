package io.isfaculty.service.impl

import io.isfaculty.dao.DisciplineRepository
import io.isfaculty.dao.OccupationTypeRepository
import io.isfaculty.dao.StudyPlanRepository
import io.isfaculty.dto.StudyPlanRequest
import io.isfaculty.model.DisciplineEntity
import io.isfaculty.model.StudyPlanEntity
import io.isfaculty.service.StudyPlanService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class StudyPlanServiceImpl @Autowired constructor(
        private val disciplineRepository: DisciplineRepository,
        private val occupationTypeRepository: OccupationTypeRepository,
        private val studyPlanRepository: StudyPlanRepository

) : StudyPlanService {

    override fun createDiscipline(discipline: String) {
        val disciplineEntity = DisciplineEntity();
        disciplineEntity.name = discipline
        disciplineRepository.save(disciplineEntity)
    }

    override fun createStudyPlan(studyPlanRequest: StudyPlanRequest) {
        val entity = StudyPlanEntity()

        entity.disciplineEntity = disciplineRepository.findById(studyPlanRequest.disciplineId!!).get()
        entity.occupationTypeEntity = occupationTypeRepository.findById(studyPlanRequest.occupationTypeId!!).get()
        entity.hours = studyPlanRequest.hours
        entity.courseNumber = studyPlanRequest.course
        entity.semesterNumber = studyPlanRequest.semestr

        studyPlanRepository.save(entity)
    }

}