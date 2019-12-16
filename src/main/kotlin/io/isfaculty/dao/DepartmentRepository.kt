package io.isfaculty.dao

import io.isfaculty.model.DepartmentEntity
import org.springframework.data.jpa.repository.JpaRepository

interface DepartmentRepository : JpaRepository<DepartmentEntity, Int> {

    fun findByIdDepartmentIn(idDepartment: List<Int?>): List<DepartmentEntity>

}