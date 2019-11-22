package io.isfaculty.service

import io.isfaculty.dto.Student

interface StudentService {

    fun createStudent(student: Student)
}