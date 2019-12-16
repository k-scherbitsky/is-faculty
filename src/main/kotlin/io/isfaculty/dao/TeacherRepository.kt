package io.isfaculty.dao

import io.isfaculty.model.TeacherEntity
import org.springframework.data.jpa.repository.JpaRepository

interface TeacherRepository: JpaRepository<TeacherEntity, Int> {

}