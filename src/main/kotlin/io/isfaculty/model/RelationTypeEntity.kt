package io.isfaculty.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "relation_type", schema = "public")
class RelationTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_relation_type", unique = true, nullable = false)
    var idRelationType: Int? = null

    @Column(name = "name", nullable = false)
    var name: String? = null
}