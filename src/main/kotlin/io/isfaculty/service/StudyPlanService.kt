package io.isfaculty.service

import io.isfaculty.dto.StudyPlanRequest

interface StudyPlanService {
    fun createDiscipline(discipline: String)
    fun createStudyPlan(studyPlanRequest: StudyPlanRequest)
}