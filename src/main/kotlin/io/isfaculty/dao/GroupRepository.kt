package io.isfaculty.dao

import io.isfaculty.model.GroupEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface GroupRepository: JpaRepository<GroupEntity, Long> {

    @Query("select g from GroupEntity g where lower(g.name)= lower(:name)")
    fun findByName(@Param("name") name: String): GroupEntity

}