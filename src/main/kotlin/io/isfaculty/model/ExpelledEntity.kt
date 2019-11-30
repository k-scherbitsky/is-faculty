package io.isfaculty.model

import java.util.*
import javax.persistence.*

@Embeddable
@Table(name = "expelled", schema = "public")
class ExpelledEntity {

    @ManyToOne(targetEntity = StudentEntity::class)
    @JoinColumn(name = "id_student", nullable = false)
    var studentEntity: StudentEntity? = null

    @Column(name = "by_choice")
    var isByChoice: Boolean? = null

    @Column(name = "date_expelled", nullable = false)
    var dateExpelled: Date? = null
}