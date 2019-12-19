package io.isfaculty.dao

import io.isfaculty.model.StudyPlanEntity
import org.springframework.data.jpa.repository.JpaRepository

interface StudyPlanRepository : JpaRepository<StudyPlanEntity, Int> {

}