package io.isfaculty.model

import javax.persistence.*

@Embeddable
@Table(name = "curator", schema = "public")
class CuratorEntity {

    @OneToOne(targetEntity = HumanEntity::class)
    @JoinColumn(name = "id_human", referencedColumnName = "id_human", nullable = false)
    var humanEntity: HumanEntity? = null

    @ManyToOne(targetEntity = GroupEntity::class)
    @JoinColumn(name = "id_group", nullable = false)
    var groupEntity: GroupEntity? = null
}