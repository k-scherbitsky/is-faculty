package io.isfaculty.dao

import io.isfaculty.model.AccountEntity
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository: JpaRepository<AccountEntity, Long> {

    fun findByUsername(username: String?): AccountEntity?
}