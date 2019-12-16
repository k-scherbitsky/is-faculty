package io.isfaculty.dto

data class Address(
        var country: String? = null,
        var city: String? = null,
        var street: String? = null,
        var house: Int? = null,
        var building: Int? = null,
        var flat: Int? = null,
        var legalAddress: Boolean? = null
)