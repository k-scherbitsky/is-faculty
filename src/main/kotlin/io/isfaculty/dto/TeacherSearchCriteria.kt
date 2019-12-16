package io.isfaculty.dto

data class TeacherSearchCriteria (
        var department: String? = null,
        var facultys: String? = null,
        var teacherTypes: String? = null
)