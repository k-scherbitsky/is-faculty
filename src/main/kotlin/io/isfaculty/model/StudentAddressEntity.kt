package io.isfaculty.model

import java.util.*
import javax.persistence.*

@Embeddable
@Table(name = "student_address", schema = "public")
class StudentAddressEntity {

    @ManyToOne(targetEntity = StudentEntity::class)
    @JoinColumn(name = "id_student", nullable = false)
    var studentEntity: StudentEntity? = null

    @Column(name = "country", nullable = false)
    var country: String? = null

    @Column(name = "street", nullable = false)
    var street: String? = null

    @Column(name = "house", nullable = false)
    var house: Int? = null

    @Column(name = "building")
    var building: Int? = null

    @Column(name = "flat", nullable = false)
    var flat: Int? = null

    @Column(name = "city", nullable = false)
    var city: String? = null

    @Column(name = "legal_address", nullable = false)
    var isLegalAddress: Boolean? = null

}