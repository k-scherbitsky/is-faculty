package io.isfaculty.dao

import io.isfaculty.model.HumanEntity
import io.isfaculty.model.TeacherEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface TeacherRepository: JpaRepository<TeacherEntity, Int> {
    fun findByHumanEntity(humanEntity: HumanEntity?): TeacherEntity?

    @Query("select s from TeacherEntity s where upper(s.humanEntity.firstName) like concat('%',upper(:firstName),'%') or upper(s.humanEntity.lastName) like concat('%',upper(:lastName),'%') or upper(s.humanEntity.middleName) like concat('%',upper(:middleName),'%')")
    fun findByFullName(@Param("firstName") firstName: String?, @Param("lastName") lastName: String?, @Param("middleName") middleName: String?): List<TeacherEntity>

}