package io.isfaculty.model

import java.util.*
import javax.persistence.*

@Embeddable
@Table(name = "student_parents", schema = "public")
class StudentParentsEntity {

    @ManyToOne(targetEntity = StudentEntity::class)
    @JoinColumn(name = "id_student", nullable = false)
    var studentEntity: StudentEntity? = null

    @ManyToOne(targetEntity = RelationTypeEntity::class)
    @JoinColumn(name = "id_relation_type", nullable = false)
    var relationTypeEntity: RelationTypeEntity? = null

    @ManyToOne(targetEntity = HumanEntity::class)
    @JoinColumn(name = "id_human", nullable = false)
    var humanEntity: HumanEntity? = null
}