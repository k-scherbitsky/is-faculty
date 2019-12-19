package io.isfaculty.model

import javax.persistence.*

@Entity
@Table(name = "curator", schema = "public")
class CuratorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "curator_id", unique = true, nullable = false)
    var curatorId: Long? = null

    @OneToOne(targetEntity = HumanEntity::class)
    @JoinColumn(name = "id_human", referencedColumnName = "id_human", nullable = false)
    var humanEntity: HumanEntity? = null

    @ManyToOne(targetEntity = GroupEntity::class)
    @JoinColumn(name = "id_group", nullable = false)
    var groupEntity: GroupEntity? = null
}