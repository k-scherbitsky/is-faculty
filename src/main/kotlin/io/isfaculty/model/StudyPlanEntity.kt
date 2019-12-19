package io.isfaculty.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "study_plan", schema = "public")
class StudyPlanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_study_plan", unique = true, nullable = false)
    var idStudyPlan: Int? = null

    @ManyToOne(targetEntity = DisciplineEntity::class)
    @JoinColumn(name = "id_discpline", nullable = false)
    var disciplineEntity: DisciplineEntity? = null

    @ManyToOne(targetEntity = OccupationTypeEntity::class)
    @JoinColumn(name = "id_occupation_type", nullable = false)
    var occupationTypeEntity: OccupationTypeEntity? = null

    @Column(name = "hours", nullable = false)
    var hours: Int? = null

    @Column(name = "course_number", nullable = false)
    var courseNumber: Int? = null

    @Column(name = "semester_number", nullable = false)
    var semesterNumber: Int? = null

}