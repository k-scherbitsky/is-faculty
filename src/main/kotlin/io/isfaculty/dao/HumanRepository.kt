package io.isfaculty.dao

import io.isfaculty.model.HumanEntity
import org.springframework.data.jpa.repository.JpaRepository

interface HumanRepository: JpaRepository<HumanEntity, Long> {


}