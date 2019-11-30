package io.isfaculty.model

import java.util.*
import javax.persistence.*

@Embeddable
@Table(name = "grant", schema = "public")
class GrantEntity {

    @OneToOne(targetEntity = StudentEntity::class)
    @JoinColumn(name = "id_student", nullable = false)
    var studentEntity: StudentEntity? = null

    @Column(name = "active", nullable = false)
    var isActive: Boolean? = null

}