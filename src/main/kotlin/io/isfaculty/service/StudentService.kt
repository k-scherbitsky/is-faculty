package io.isfaculty.service

import io.isfaculty.dto.Expelled
import io.isfaculty.dto.FullStudent
import io.isfaculty.dto.ScienceConf
import io.isfaculty.dto.Student
import io.isfaculty.dto.searchCriteria.StudentSearchCriteria

interface StudentService {

    fun createStudent(student: Student)
    fun search(searchCriteria: StudentSearchCriteria): List<Student>
    fun setSearchCriteria(): StudentSearchCriteria
    fun getFullStudent(id: Int): FullStudent?
    fun getConf(prize: Boolean): List<ScienceConf>
    fun getHeadmans(group: String): List<Student>
    fun getExpelleds(expelled: Boolean): List<Expelled>
}