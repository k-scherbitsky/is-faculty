package io.isfaculty.dao

import io.isfaculty.model.AccountEntity
import io.isfaculty.model.ExpelledEntity
import io.isfaculty.model.FacultyEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ExpelledRepository: JpaRepository<ExpelledEntity, Int> {

    fun findByByChoice(byChoice: Boolean): List<ExpelledEntity>

}