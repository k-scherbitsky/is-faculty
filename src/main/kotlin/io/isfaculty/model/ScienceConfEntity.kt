package io.isfaculty.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "science_conf", schema = "public")
class ScienceConfEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "science_conf_id", unique = true, nullable = false)
    var scienceConfId: Int? = null

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