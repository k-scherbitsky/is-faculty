package io.isfaculty.dto

data class ExamTestSerachResponse (
        var studentId: Int? = null,
        var group: String? = null,
        var firstName: String? = null,
        var lastName: String? = null,
        var discipline: String? = null,
        var occupationType: String? = null,
        var mark: Int? = null
)