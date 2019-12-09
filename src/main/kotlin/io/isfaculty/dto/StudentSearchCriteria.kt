package io.isfaculty.dto

data class StudentSearchCriteria (
        var course: Int? = null,
        var department: String? = null,
        var group: String? = null,
        var sex: String? = null,
        var birthDate: String? = null,
        var hasChildren: Boolean? = null
)