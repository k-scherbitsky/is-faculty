package io.isfaculty.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "human", schema = "public")
class HumanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_human", unique = true, nullable = false)
    var idHuman: Int? = null

    @Column(name = "first_name", nullable = false)
    var firstName: String? = null

    @Column(name = "last_name", nullable = false)
    var lastName: String? = null

    @Column(name = "middle_name")
    var middleName: String? = null

    @Column(name = "phone_number", nullable = false)
    var phoneNumber: String? = null

    @Column(name = "email", nullable = false)
    var email: String? = null

    @Column(name = "birth_date", nullable = false)
    var birthDate: Date? = null

    @Column(name = "sex", nullable = false)
    var sex: String? = null

}