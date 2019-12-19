package io.isfaculty.controller

import io.isfaculty.dao.DisciplineRepository
import io.isfaculty.dao.OccupationTypeRepository
import io.isfaculty.dto.StudyPlanRequest
import io.isfaculty.model.DisciplineEntity
import io.isfaculty.model.OccupationTypeEntity
import io.isfaculty.model.StudyPlanEntity
import io.isfaculty.service.StudyPlanService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("/study-plan")
class StudyPlanController @Autowired constructor(
        private val studyPlanService: StudyPlanService,
        private val disciplineRepository: DisciplineRepository,
        private val occupationTypeRepository: OccupationTypeRepository
) {

    @RequestMapping("")
    fun index(model: Model): String {
        return "studyPlan/index"
    }

    @RequestMapping("/create/discipline")
    fun createDiscipline(model: Model): String {
        return "studyPlan/createDiscipline"
    }

    @PostMapping("/create/discipline")
    fun createDiscipline(@RequestParam discipline: String): String {
        studyPlanService.createDiscipline(discipline)
        return "studyPlan/index"
    }

    @RequestMapping("/create")
    fun createStudyPlan(model: Model): String {

        val disciplines: List<DisciplineEntity> = disciplineRepository.findAll()
        val occupations: List<OccupationTypeEntity> = occupationTypeRepository.findAll()

        model.addAttribute("disciplines", disciplines)
        model.addAttribute("occupations", occupations)
        model.addAttribute("studyPlan", StudyPlanRequest())

        return "studyPlan/createStudyPlan"
    }

    @PostMapping("/create")
    fun createStudyPlan(@ModelAttribute studyPlanRequest: StudyPlanRequest, model: Model): String {
        studyPlanService.createStudyPlan(studyPlanRequest)
        return "studyPlan/index"
    }


}