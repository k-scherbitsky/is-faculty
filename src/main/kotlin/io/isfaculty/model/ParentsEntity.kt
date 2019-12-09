package io.isfaculty.model

import java.util.*
import javax.persistence.*


@Entity
@Table(name = "parents", schema = "public")
class ParentsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_parent", unique = true, nullable = false)
    var idParent: Int? = null

    @ManyToOne(targetEntity = RelationTypeEntity::class)
    @JoinColumn(name = "id_relationship", nullable = false)
    var relationTypeEntity: RelationTypeEntity? = null

    @ManyToOne(targetEntity = HumanEntity::class)
    @JoinColumn(name = "id_human", nullable = false)
    var humanEntity: HumanEntity? = null

    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE])
    @JoinTable(name = "parents_student",
            joinColumns = [JoinColumn(name = "id_parent")],
            inverseJoinColumns = [JoinColumn(name = "id_student")])
    private val students: List<StudentEntity> = mutableListOf()
}