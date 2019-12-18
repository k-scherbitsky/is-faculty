package io.isfaculty.service

import io.isfaculty.dto.FullStudent
import io.isfaculty.dto.ScienceConf
import io.isfaculty.dto.Student
import io.isfaculty.dto.StudentSearchCriteria
import io.isfaculty.model.ScienceConfEntity

interface StudentService {

    fun createStudent(student: Student)
    fun search(searchCriteria: StudentSearchCriteria): List<Student>
    fun setSearchCriteria(): StudentSearchCriteria
    fun getFullStudent(id: Int): FullStudent?
    fun getConf(prize: Boolean): List<ScienceConf>
}