package io.isfaculty.controller

import io.isfaculty.dto.FullStudent
import io.isfaculty.dto.Student
import io.isfaculty.dto.StudentSearchCriteria
import io.isfaculty.service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

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

    @RequestMapping("/{id}")
    fun getFullStudent(@PathVariable id: Int, model: Model): String {

        val student: FullStudent? = studentService.getFullStudent(id);
        model.addAttribute("student", student)
        return "student/page"
    }

    @GetMapping("/result")
    fun search(@ModelAttribute searchCriteria: StudentSearchCriteria, model: Model): String {
        val studentList: List<Student> = studentService.search(searchCriteria)

        if(studentList.isEmpty()) {
            model.addAttribute("isEmpty", true)
        } else {
            model.addAttribute("isEmpty", false)
            model.addAttribute("studentList", studentList)
        }

        return "student/result"
    }

    @RequestMapping("/search")
    fun searchStudent(model: Model): String {
        model.addAttribute("searchCriteria", studentService.setSearchCriteria())
        return "student/search"
    }

}