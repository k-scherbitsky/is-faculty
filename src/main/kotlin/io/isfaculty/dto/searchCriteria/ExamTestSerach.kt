package io.isfaculty.dto.searchCriteria

data class ExamTestSerach (
        var groupIds: String? = null,
        var studyPlanId: Int? = null,
        var disciplineId: Int? = null,
        var mark: Int? = null
)