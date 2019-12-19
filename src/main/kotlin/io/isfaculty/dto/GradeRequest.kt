package io.isfaculty.dto

data class GradeRequest (
        var studentId: Int? = null,
        var teacherId: Int? = null,
        var grade: Int? = null,
        var studyPlanId: Int? = null
)