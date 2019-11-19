package io.isfaculty.security

import io.isfaculty.dao.AccountRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class AccountDetailsServiceImpl
@Autowired constructor(private val accountRepository: AccountRepository) : UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails {
        val admin = accountRepository.findByUsername(username)

        return AccountDetailsImpl(admin)
    }
}