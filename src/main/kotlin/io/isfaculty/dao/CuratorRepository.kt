package io.isfaculty.dao

import io.isfaculty.model.CuratorEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CuratorRepository: JpaRepository<CuratorEntity, Int> {

    fun findAllByGroupEntity_IdGroupIn(ids: List<Int?>): List<CuratorEntity>

}