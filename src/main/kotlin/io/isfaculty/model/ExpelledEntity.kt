package io.isfaculty.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "expelled", schema = "public")
class ExpelledEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "expelled_id", unique = true, nullable = false)
    var expelledId: Int? = null

    @ManyToOne(targetEntity = StudentEntity::class)
    @JoinColumn(name = "id_student", nullable = false)
    var studentEntity: StudentEntity? = null

    @Column(name = "by_choice")
    var byChoice: Boolean? = null

    @Column(name = "date_expelled", nullable = false)
    var dateExpelled: Date? = null
}