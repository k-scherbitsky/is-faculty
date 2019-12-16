package io.isfaculty.service

import io.isfaculty.dto.Teacher

interface TeacherService {
    fun createStudent(teacher: Teacher)
}