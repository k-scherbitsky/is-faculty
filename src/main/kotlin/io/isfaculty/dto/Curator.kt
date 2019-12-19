package io.isfaculty.dto

data class Curator (
        var id: Int? = null,
        var firstName: String? = null,
        var lastName: String? = null,
        var middleName: String? = null,
        var group: String? = null,
        var teacher: Boolean? = null
)