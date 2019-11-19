package io.isfaculty.model

import java.util.*
import javax.persistence.*

@Embeddable
@Table(name = "grade", schema = "public")
class GradeEntity {

    @ManyToOne(targetEntity = StudentEntity::class)
    @JoinColumn(name = "id_student", nullable = false)
    var studentEntity: StudentEntity? = null

    @ManyToOne(targetEntity = TeacherEntity::class)
    @JoinColumn(name = "id_teacher", nullable = false)
    var teacherEntity: TeacherEntity? = null

    @ManyToOne(targetEntity = ControlTypeEntity::class)
    @JoinColumn(name = "id_control_type", nullable = false)
    var controlTypeEntity: ControlTypeEntity? = null

    @ManyToOne(targetEntity = StudyPlanEntity::class)
    @JoinColumn(name = "id_study_plan", nullable = false)
    var studyPlanEntity: StudyPlanEntity? = null

    @Column(name = "grade", nullable = false)
    var grade: Int? = null

    @Column(name = "created_date", nullable = false)
    var createdDate: Date? = null
}