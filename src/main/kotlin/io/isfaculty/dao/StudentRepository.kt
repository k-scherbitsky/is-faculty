package io.isfaculty.dao

import io.isfaculty.model.HumanEntity
import io.isfaculty.model.StudentEntity
import org.springframework.data.jpa.repository.JpaRepository

interface StudentRepository : JpaRepository<StudentEntity, Int> {

    fun findByHumanEntity(humanEntity: HumanEntity?): StudentEntity?
}