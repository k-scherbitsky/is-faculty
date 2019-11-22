package io.isfaculty.dao

import io.isfaculty.model.StudyFormEntity
import org.springframework.data.jpa.repository.JpaRepository

interface StudyFormRepository: JpaRepository<StudyFormEntity, Long> {

    fun findByName(name: String): StudyFormEntity
}