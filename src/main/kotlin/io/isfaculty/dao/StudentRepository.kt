package io.isfaculty.dao

import io.isfaculty.model.StudentEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.jpa.repository.QueryHints
import org.springframework.data.querydsl.binding.QuerydslPredicate
import org.springframework.data.repository.query.Param

interface StudentRepository : JpaRepository<StudentEntity, Int> {


}