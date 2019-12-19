package io.isfaculty.controller

import io.isfaculty.model.DisciplineEntity
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
        private val studyPlanService: StudyPlanService
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

}