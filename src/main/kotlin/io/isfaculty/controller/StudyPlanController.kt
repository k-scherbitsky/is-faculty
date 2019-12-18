package io.isfaculty.controller

import io.isfaculty.model.DisciplineEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/study-plan")
class StudyPlanController {

    @RequestMapping("")
    fun index(model: Model): String {
        return "studyPlan/index"
    }

    @RequestMapping("/create-discipline")
    fun createDiscipline(model: Model): String {
        model.addAttribute("discipline", DisciplineEntity())
        return "student/create"
    }

    @PostMapping("/create-discipline")
    fun createDiscipline(@ModelAttribute discipline: DisciplineEntity): String {
//        studentService.createStudent(student)
        return "student/index"
    }

}