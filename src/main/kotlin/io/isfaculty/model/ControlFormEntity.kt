package io.isfaculty.model

import javax.persistence.*

@Embeddable
@Table(name = "control_form", schema = "public")
class ControlFormEntity {

    @ManyToOne(targetEntity = DisciplineEntity::class)
    @JoinColumn(name = "id_discipline", nullable = false)
    var disciplineEntity: DisciplineEntity? = null

    @ManyToOne(targetEntity = ControlTypeEntity::class)
    @JoinColumn(name = "id_control_type", nullable = false)
    var controlTypeEntity: ControlTypeEntity? = null

    @Column(name = "course_number", nullable = false)
    var courseNumber: Int? = null

    @Column(name = "semester_number", nullable = false)
    var semesterNumber: Int? = null

}