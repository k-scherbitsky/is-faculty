package io.isfaculty.service.impl

import io.isfaculty.dao.DisciplineRepository
import io.isfaculty.model.DisciplineEntity
import io.isfaculty.service.StudyPlanService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class StudyPlanServiceImpl @Autowired constructor(
        private val disciplineRepository: DisciplineRepository
) : StudyPlanService {

    override fun createDiscipline(discipline: String) {
        val disciplineEntity = DisciplineEntity();
        disciplineEntity.name = discipline
        disciplineRepository.save(disciplineEntity)
    }

}