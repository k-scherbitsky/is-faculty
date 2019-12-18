package io.isfaculty.service

import io.isfaculty.dto.FullTeacher
import io.isfaculty.dto.Teacher
import io.isfaculty.dto.searchCriteria.TeacherSearchCriteria

interface TeacherService {
    fun createStudent(teacher: Teacher)
    fun getFullTeacher(id: Int): FullTeacher?
    fun search(searchCriteria: TeacherSearchCriteria): List<FullTeacher?>
}