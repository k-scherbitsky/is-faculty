package io.isfaculty.dao

import io.isfaculty.model.ScienceConfEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface ScienceConfRepository: JpaRepository<ScienceConfEntity, Int> {

    @Query("select s from ScienceConfEntity s where s.place <= 3")
    fun findByPrize(): List<ScienceConfEntity>
}