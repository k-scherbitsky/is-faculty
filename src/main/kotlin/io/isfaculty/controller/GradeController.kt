package io.isfaculty.controller

import io.isfaculty.dao.*
import io.isfaculty.dto.GradeRequest
import io.isfaculty.model.StudentEntity
import io.isfaculty.model.StudyPlanEntity
import io.isfaculty.model.TeacherEntity
import io.isfaculty.service.GradeService
import io.isfaculty.service.StudyPlanService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("/grade")
class GradeController @Autowired constructor(
        private val studyPlanRepository: StudyPlanRepository,
        private val studentRepository: StudentRepository,
        private val teacherRepository: TeacherRepository,
        private val gradeService: GradeService
){

    @RequestMapping("")
    fun index(model: Model): String {
        return "grade/index"
    }

    @RequestMapping("/add")
    fun addMark(model: Model): String {

        val teachers: List<TeacherEntity> = teacherRepository.findAll()
        val teachersMap: HashMap<Int, String> = HashMap()
        for (teacher in teachers) {
            teachersMap[teacher.idTeacher!!] = "${teacher.humanEntity?.firstName} ${teacher.humanEntity?.middleName} ${teacher.humanEntity?.lastName}"
        }

        val students: List<StudentEntity> = studentRepository.findAll()
        val studentsMap: HashMap<Int, String> = HashMap()
        for (student in students) {
            studentsMap[student.idStudent!!] = "${student.humanEntity?.firstName} ${student.humanEntity?.lastName}, гр. ${student.groupEntity?.name}"
        }

        val studyPlans: List<StudyPlanEntity> = studyPlanRepository.findAll()
        val studyPlanMap: HashMap<Int, String> = HashMap()
        for (studyPlan in studyPlans) {
            studyPlanMap[studyPlan.idStudyPlan!!] = "${studyPlan.occupationTypeEntity?.name} - ${studyPlan.disciplineEntity?.name} - ${studyPlan.courseNumber} к. - ${studyPlan.semesterNumber} сем."
        }

        model.addAttribute("studyPlans", studyPlanMap)
        model.addAttribute("students", studentsMap)
        model.addAttribute("teachers", teachersMap)
        model.addAttribute("gradeRequest", GradeRequest())

        return "grade/add"
    }

    @PostMapping("/add")
    fun addMark(@ModelAttribute gradeRequest: GradeRequest): String {

        gradeService.addMark(gradeRequest)

        return "grade/index"
    }

}