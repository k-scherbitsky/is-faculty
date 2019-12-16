package io.isfaculty.dto

import io.isfaculty.model.DepartmentEntity

data class Teacher (
        var teacherId: Int? = null,
        var firstName: String? = null,
        var lastName: String? = null,
        var middleName: String? = null,
        var birthDate: String? = null,
        var sex: String? = null,
        var phoneNumber: String? = null,
        var email: String? = null,
        var teacherTypeId: Int? = null,
        var departments: String? = null,
        var address: Address? = null
)