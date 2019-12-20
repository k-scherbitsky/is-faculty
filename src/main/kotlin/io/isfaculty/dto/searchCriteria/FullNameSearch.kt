package io.isfaculty.dto.searchCriteria

data class FullNameSearch(
        var firstName: String? = null,
        var lastName: String? = null,
        var middleName: String? = null
)