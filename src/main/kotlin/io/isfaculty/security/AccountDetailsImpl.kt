package io.isfaculty.security

import io.isfaculty.model.AccountEntity
import io.isfaculty.model.UserRole
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class AccountDetailsImpl(private val accountEntity: AccountEntity?) : UserDetails {

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {

        val roleNames = UserRole.values()
        val grantList: MutableList<GrantedAuthority> = ArrayList()

        for (role in roleNames){
            val authority: GrantedAuthority = SimpleGrantedAuthority(role.name)
            grantList.add(authority)
        }

        return grantList
    }

    override fun isEnabled(): Boolean = true

    override fun getUsername(): String? = accountEntity?.username

    override fun isCredentialsNonExpired(): Boolean = true

    override fun getPassword(): String? = accountEntity?.password

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true
}