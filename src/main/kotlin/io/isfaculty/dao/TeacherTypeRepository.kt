package io.isfaculty.dao

import io.isfaculty.model.TeacherTypeEntity
import org.springframework.data.jpa.repository.JpaRepository

interface TeacherTypeRepository: JpaRepository<TeacherTypeEntity, Int> {

}