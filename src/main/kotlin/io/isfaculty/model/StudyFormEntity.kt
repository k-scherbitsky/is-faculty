package io.isfaculty.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "study_form", schema = "public")
class StudyFormEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_study_form", unique = true, nullable = false)
    var idStudyForm: Int? = null

    @Column(name = "name", nullable = false)
    var name: String? = null
}