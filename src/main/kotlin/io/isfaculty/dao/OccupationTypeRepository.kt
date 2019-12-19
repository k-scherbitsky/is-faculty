package io.isfaculty.dao

import io.isfaculty.model.OccupationTypeEntity
import org.springframework.data.jpa.repository.JpaRepository

interface OccupationTypeRepository : JpaRepository<OccupationTypeEntity, Int> {

}