package io.isfaculty.controller

import io.isfaculty.dto.Student
import io.isfaculty.dto.StudentSearchCriteria
import io.isfaculty.service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/student")
class StudentController @Autowired constructor(private val studentService: StudentService) {

    @RequestMapping("")
    fun index(model: Model): String {
        return "student/index"
    }

    @RequestMapping("/create")
    fun createStudent(model: Model): String {
        model.addAttribute("student", Student())
        return "student/create"
    }

    @PostMapping("/create")
    fun createStudent(@ModelAttribute student: Student): String {
        studentService.createStudent(student)
        return "student/index"
    }

    @RequestMapping("/search")
    fun search(model: Model): String {
        model.addAttribute("student", Student())
        return "student/search"
    }

    @GetMapping("/search")
    fun search(@ModelAttribute searchCriteria: StudentSearchCriteria): String {
        val student: Student = studentService.search(searchCriteria)
        return "student/search"
    }

}