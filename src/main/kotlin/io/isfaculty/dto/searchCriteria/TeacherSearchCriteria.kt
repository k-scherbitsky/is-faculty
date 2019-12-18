package io.isfaculty.dto.searchCriteria

data class TeacherSearchCriteria (
        var department: String? = null,
        var faculties: String? = null,
        var teacherTypes: String? = null
)