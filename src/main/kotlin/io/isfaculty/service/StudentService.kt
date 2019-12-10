package io.isfaculty.service

import io.isfaculty.dto.Student
import io.isfaculty.dto.StudentSearchCriteria

interface StudentService {

    fun createStudent(student: Student)
    fun search(searchCriteria: StudentSearchCriteria): List<Student>
    fun setSearchCriteria(): StudentSearchCriteria
}