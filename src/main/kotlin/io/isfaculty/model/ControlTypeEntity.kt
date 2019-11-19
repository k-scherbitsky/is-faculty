package io.isfaculty.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "control_type", schema = "public")
class ControlTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_control_type", unique = true, nullable = false)
    var idControlType: Int? = null

    @Column(name = "name", nullable = false)
    var name: String? = null

    @OneToOne(targetEntity = HumanEntity::class)
    @JoinColumn(name = "id_human", referencedColumnName = "id_human", nullable = false)
    var humanEntity: HumanEntity? = null
}