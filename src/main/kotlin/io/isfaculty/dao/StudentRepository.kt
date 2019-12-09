package io.isfaculty.dao

import io.isfaculty.model.StudentEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.util.*

interface StudentRepository : JpaRepository<StudentEntity, Long> {

    @Query("select s from StudentEntity s where " +
            "s.hasChildren = :hasChildren " +
//            "and s.humanEntity.birthDate = :birth" +
            "or s.courseNumber = :course " +
            "or lower(s.groupEntity.name) = lower(:group) " +
            "or lower(s.groupEntity.departmentEntity.name) = lower(:dept) " +
            "or s.humanEntity.sex = :sex " +
            "order by s.idStudent asc")
    fun findBySearching(
            @Param("hasChildren") hasChildren: Boolean?,
            @Param("course") course: Int?,
            @Param("group") group: String?,
            @Param("dept") dept: String?,
            @Param("sex") sex: String?
    ): List<StudentEntity>

}