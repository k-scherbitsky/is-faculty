package io.isfaculty.controller

import io.isfaculty.dao.DepartmentRepository
import io.isfaculty.dao.FacultyRepository
import io.isfaculty.dao.TeacherTypeRepository
import io.isfaculty.dto.*
import io.isfaculty.model.TeacherTypeEntity
import io.isfaculty.service.TeacherService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/teacher")
class TeacherController @Autowired constructor(
        private val teacherService: TeacherService,
        private val teacherTypeRepository: TeacherTypeRepository,
        private val departmentRepository: DepartmentRepository,
        private val facultyRepository: FacultyRepository
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

    @RequestMapping("/search")
    fun searchTeacher(model: Model): String {

        model.addAttribute("depts", departmentRepository.findAll())
        model.addAttribute("teacherTypes", teacherTypeRepository.findAll())
        model.addAttribute("faculties", facultyRepository.findAll())
        model.addAttribute("searchCriteria", TeacherSearchCriteria())

        return "teacher/search"
    }

    @GetMapping("/result")
    fun search(@ModelAttribute searchCriteria: TeacherSearchCriteria, model: Model): String {
        val teacherList: List<FullTeacher?> = teacherService.search(searchCriteria)

        if(teacherList.isEmpty()) {
            model.addAttribute("isEmpty", true)
        } else {
            model.addAttribute("isEmpty", false)
            model.addAttribute("teacherList", teacherList)
        }

        return "teacher/result"
    }

}