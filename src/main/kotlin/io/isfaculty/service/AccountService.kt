package io.isfaculty.service

import io.isfaculty.dao.AccountRepository
import io.isfaculty.model.AccountEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class AccountService {

    @Autowired
    private lateinit var accountRepository: AccountRepository

    @Autowired
    private lateinit var bCryptPasswordEncoder: BCryptPasswordEncoder

    fun create(accountEntity: AccountEntity): AccountEntity {
        accountEntity.password = bCryptPasswordEncoder.encode(accountEntity.password)
        return accountRepository.save(accountEntity)
    }
}