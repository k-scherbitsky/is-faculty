package io.isfaculty.service

import io.isfaculty.dto.ExamTestSerach
import io.isfaculty.dto.ExamTestSerachResponse
import io.isfaculty.dto.GradeRequest

interface GradeService {
    fun addMark(gradeRequest: GradeRequest)
    fun examOrTest(examTestSerach: ExamTestSerach): List<ExamTestSerachResponse?>
}