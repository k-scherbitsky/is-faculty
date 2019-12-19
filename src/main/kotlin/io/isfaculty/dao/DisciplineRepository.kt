package io.isfaculty.dao

import io.isfaculty.model.DisciplineEntity
import org.springframework.data.jpa.repository.JpaRepository

interface DisciplineRepository : JpaRepository<DisciplineEntity, Int> {

}