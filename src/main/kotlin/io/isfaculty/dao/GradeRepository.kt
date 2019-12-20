package io.isfaculty.dao

import io.isfaculty.model.GradeEntity
import io.isfaculty.model.GroupEntity
import io.isfaculty.model.StudyPlanEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface GradeRepository : JpaRepository<GradeEntity, Long> {

    fun findAllByStudyPlanEntity_IdStudyPlanAndGrade(studyPlanId: Int, grade: Int): List<GradeEntity>

}