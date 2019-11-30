package io.isfaculty.dao

import io.isfaculty.model.GroupEntity
import org.springframework.data.jpa.repository.JpaRepository

interface GroupRepository: JpaRepository<GroupEntity, Long> {

    fun findByName(name: String): GroupEntity

}