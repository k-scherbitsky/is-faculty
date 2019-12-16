package io.isfaculty.dto

import io.isfaculty.model.AddressEntity
import io.isfaculty.model.ParentsEntity

data class FullStudent(
        var studentId: Int? = null,
        var firstName: String? = null,
        var lastName: String? = null,
        var middleName: String? = null,
        var sex: String? = null,
        var birthDate: String? = null,
        var recordBook: String? = null,
        var phoneNumber: String? = null,
        var email: String? = null,
        var group: String? = null,
        var department: String? = null,
        var faculty: String? = null,
        var admissionDate: String? = null,
        var addresses: List<AddressEntity>? = mutableListOf(),
        var parents: List<ParentsEntity>? = mutableListOf()/*,
        var stipend: Double? = null,
        var confs: List<ScienceConf> = mutableListOf(),
        */
)