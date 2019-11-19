package io.isfaculty.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "occupation_type", schema = "public")
class OccupationTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_occupation", unique = true, nullable = false)
    var idOccupation: Int? = null

    @Column(name = "name", nullable = false)
    var name: String? = null
}