package io.isfaculty.dto

data class StudentSearchCriteria (
        var course: String? = null,
        var department: String? = null,
        var facultyList: List<String>? = null,
        var groupList: List<String>? = null,
        var group: String? = null,
        var faculty: String? = null,
        var sex: String? = null,
        var birthDate: String? = null,
        var hasChildren: Boolean? = null
)