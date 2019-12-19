package io.isfaculty.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "grade", schema = "public")
class GradeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grade_id", unique = true, nullable = false)
    var gradeId: Long? = null

    @ManyToOne(targetEntity = StudentEntity::class)
    @JoinColumn(name = "id_student", nullable = false)
    var studentEntity: StudentEntity? = null

    @ManyToOne(targetEntity = TeacherEntity::class)
    @JoinColumn(name = "id_teacher", nullable = false)
    var teacherEntity: TeacherEntity? = null

    @ManyToOne(targetEntity = StudyPlanEntity::class)
    @JoinColumn(name = "id_study_plan", nullable = false)
    var studyPlanEntity: StudyPlanEntity? = null

    @Column(name = "grade", nullable = false)
    var grade: Int? = null

    @Column(name = "created_date", nullable = false)
    var createdDate: Date? = null
}