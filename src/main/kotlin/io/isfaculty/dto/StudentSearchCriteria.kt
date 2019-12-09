package io.isfaculty.dto

data class StudentSearchCriteria (
        var course: String? = null,
        var department: String? = null,
        var group: String? = null,
        var sex: String? = null,
        var birthDate: String? = null,
        var children: Boolean? = null
)