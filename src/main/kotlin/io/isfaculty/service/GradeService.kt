package io.isfaculty.service

import io.isfaculty.dto.GradeRequest

interface GradeService {
    fun addMark(gradeRequest: GradeRequest)
}