package io.isfaculty.service

import io.isfaculty.dto.*
import io.isfaculty.dto.searchCriteria.StudentSearchCriteria

interface StudentService {

    fun createStudent(student: Student)
    fun search(searchCriteria: StudentSearchCriteria): List<Student>
    fun setSearchCriteria(): StudentSearchCriteria
    fun getFullStudent(id: Int): FullStudent?
    fun getConf(prize: Boolean): List<ScienceConf>
    fun getHeadmans(group: String): List<Student>
    fun getExpelleds(expelled: Boolean): List<Expelled>
    fun getCurators(group: String): List<Curator>
}