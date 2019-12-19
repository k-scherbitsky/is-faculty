package io.isfaculty.dto

data class StudyPlanRequest (
        var disciplineId: Int? = null,
        var occupationTypeId: Int? = null,
        var hours: Int? = null,
        var course: Int? = null,
        var semestr: Int? = null

)