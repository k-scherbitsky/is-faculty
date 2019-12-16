package io.isfaculty.controller

import io.isfaculty.dao.DepartmentRepository
import io.isfaculty.dao.TeacherTypeRepository
import io.isfaculty.dto.FullStudent
import io.isfaculty.dto.FullTeacher
import io.isfaculty.dto.Student
import io.isfaculty.dto.Teacher
import io.isfaculty.model.TeacherTypeEntity
import io.isfaculty.service.TeacherService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/teacher")
class TeacherController @Autowired constructor(
        private val teacherService: TeacherService,
        private val teacherTypeRepository: TeacherTypeRepository,
        private val departmentRepository: DepartmentRepository
) {

    @RequestMapping("")
    fun index(model: Model): String {
        return "teacher/index"
    }

    @RequestMapping("/create")
    fun createTeacher(model: Model): String {

        model.addAttribute("teacherTypes", teacherTypeRepository.findAll())
        model.addAttribute("depts", departmentRepository.findAll())
        model.addAttribute("teacher", Teacher())
        return "teacher/create"
    }

    @PostMapping("/create")
    fun createTeacher(@ModelAttribute teacher: Teacher): String {
        teacherService.createStudent(teacher)
        return "teacher/index"
    }

    @RequestMapping("/{id}")
    fun getFullTeacher(@PathVariable id: Int, model: Model): String {

        val teacher: FullTeacher? = teacherService.getFullTeacher(id);
        model.addAttribute("teacher", teacher)
        return "teacher/page"
    }

}