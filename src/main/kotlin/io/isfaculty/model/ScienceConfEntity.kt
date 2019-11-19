package io.isfaculty.model

import java.util.*
import javax.persistence.*

@Embeddable
@Table(name = "science_conf", schema = "public")
class ScienceConfEntity {

    @ManyToOne(targetEntity = StudentEntity::class)
    @JoinColumn(name = "id_student", nullable = false)
    var studentEntity: StudentEntity? = null

    @Column(name = "conf_name", nullable = false)
    var confName: String? = null

    @Column(name = "place")
    var place: Int? = null

    @Column(name = "created_date", nullable = false)
    var createdDate: Date? = null
}