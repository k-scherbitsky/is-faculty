package io.isfaculty.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "student", schema = "public")
class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_student", unique = true, nullable = false)
    var idStudent: Int? = null

    @Column(name = "id_record_book", nullable = false)
    var idRecordBook: String? = null

    @OneToOne(targetEntity = GroupEntity::class)
    @JoinColumn(name = "id_group", nullable = false)
    var groupEntity: GroupEntity? = null

    @OneToOne(targetEntity = StudyFormEntity::class)
    @JoinColumn(name = "id_study_form", nullable = false)
    var studyFormEntity: StudyFormEntity? = null

    @OneToOne(targetEntity = HumanEntity::class)
    @JoinColumn(name = "id_human", referencedColumnName = "id_human", nullable = false)
    var humanEntity: HumanEntity? = null

    @Column(name = "admission_date", nullable = false)
    var admissionDate: Date? = null


}