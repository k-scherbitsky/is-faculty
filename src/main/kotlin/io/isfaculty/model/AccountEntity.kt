package io.isfaculty.model

import org.springframework.data.annotation.CreatedDate
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "account", schema = "public")
class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_account", unique = true, nullable = false)
    var idAccount: Int? = null

    @Column(name = "user_role")
    @Enumerated(EnumType.STRING)
    var userRole: UserRole? = null

    @Column(name = "username")
    var username: String? = null

    @Column(name = "password")
    var password: String? = null

    @Column(name = "created_date", nullable = false)
    @CreatedDate
    val createdDate: Date = Date()

}