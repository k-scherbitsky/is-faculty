package io.isfaculty.dto

data class Student(
        var studentId: Int? = null,
        var firstName: String? = null,
        var lastName: String? = null,
        var middleName: String? = null,
        var birthDate: String? = null,
        var phoneNumber: String? = null,
        var email: String? = null,
        var recordBook: String? = null,
        var studyForm: String? = null,
        var admissionDate: String? = null,
        var group: String? = null,
        var hasChildren: Boolean? = null,
        var sex: String? = null
)