package io.isfaculty.dto

import io.isfaculty.model.AddressEntity
import io.isfaculty.model.ParentsEntity

data class FullTeacher(
        var studentId: Int? = null,
        var firstName: String? = null,
        var lastName: String? = null,
        var middleName: String? = null,
        var sex: String? = null,
        var birthDate: String? = null,
        var phoneNumber: String? = null,
        var email: String? = null,
        var rang: String? = null,
        var departments: List<String>? = null,
        var addresses: List<AddressEntity>? = mutableListOf()
)