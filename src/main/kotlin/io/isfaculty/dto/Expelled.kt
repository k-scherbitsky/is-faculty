package io.isfaculty.dto

data class Expelled (
        var studentId: Int? = null,
        var firstName: String? = null,
        var lastName: String? = null,
        var middleName: String? = null,
        var group: String? = null,
        var expelledByChoice: Boolean? = null,
        var expelledDate: String? = null
)