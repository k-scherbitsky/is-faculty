package io.isfaculty.controller

import io.isfaculty.dao.GroupRepository
import io.isfaculty.dto.*
import io.isfaculty.dto.searchCriteria.FullNameSearch
import io.isfaculty.dto.searchCriteria.StudentSearchCriteria
import io.isfaculty.service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/student")
class StudentController @Autowired constructor(
        private val studentService: StudentService,
        private val groupRepository: GroupRepository
) {

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

        if (studentList.isEmpty()) {
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

    @RequestMapping("/conf")
    fun confPage(model: Model): String {
        return "student/conf"
    }

    @GetMapping("/conf/result")
    fun confResultPage(@RequestParam(defaultValue = "false") prize: Boolean, model: Model): String {
        val confs: List<ScienceConf> = studentService.getConf(prize)

        if (confs.isEmpty()) {
            model.addAttribute("isEmpty", true)
        } else {
            model.addAttribute("isEmpty", false)
            model.addAttribute("confs", confs)
        }

        return "student/resultConf"
    }

    @RequestMapping("/headman")
    fun headmanPage(model: Model): String {
        model.addAttribute("groups", groupRepository.findAll())
        return "student/headman"
    }

    @GetMapping("/headman/result")
    fun headmanResultPage(@RequestParam group: String, model: Model): String {
        val studentList: List<Student> = studentService.getHeadmans(group)

        if (studentList.isEmpty()) {
            model.addAttribute("isEmpty", true)
        } else {
            model.addAttribute("isEmpty", false)
            model.addAttribute("studentList", studentList)
        }

        return "student/result"
    }

    @RequestMapping("/expelled")
    fun expelledPage(model: Model): String {
        return "student/expelled"
    }

    @GetMapping("/expelled/result")
    fun expelledResultPage(@RequestParam(defaultValue = "false") expelled: Boolean, model: Model): String {
        val studentList: List<Expelled> = studentService.getExpelleds(expelled)

        if (studentList.isEmpty()) {
            model.addAttribute("isEmpty", true)
        } else {
            model.addAttribute("isEmpty", false)
            model.addAttribute("studentList", studentList)
        }

        return "student/resultExpelled"
    }

    @RequestMapping("/curator")
    fun curatorPage(model: Model): String {
        model.addAttribute("groups", groupRepository.findAll())
        return "student/curator"
    }

    @GetMapping("/curator/result")
    fun curatorResultPage(@RequestParam group: String, model: Model): String {
        val curatorList: List<Curator> = studentService.getCurators(group)

        if (curatorList.isEmpty()) {
            model.addAttribute("isEmpty", true)
        } else {
            model.addAttribute("isEmpty", false)
            model.addAttribute("curatorList", curatorList)
        }

        return "student/resultCurator"
    }

    @RequestMapping("/search/by-name")
    fun searchByName(model: Model): String {

        model.addAttribute("fullName", FullNameSearch())
        return "student/searchByName"
    }

    @GetMapping("/search/by-name/result")
    fun searchByName(@ModelAttribute fullNameSearch: FullNameSearch, model: Model): String {

        val studentList: List<Student> = studentService.searchByFullName(fullNameSearch)

        if (studentList.isEmpty()) {
            model.addAttribute("isEmpty", true)
        } else {
            model.addAttribute("isEmpty", false)
            model.addAttribute("studentList", studentList)
        }

        return "student/result"
    }


}