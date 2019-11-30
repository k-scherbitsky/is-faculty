package io.isfaculty.dao

import io.isfaculty.model.StudentEntity
import org.springframework.data.jpa.repository.JpaRepository

interface StudentRepository : JpaRepository<StudentEntity, Long> {



}