package io.isfaculty.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "teacher_type", schema = "public")
class TeacherTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_teacher_type", unique = true, nullable = false)
    var idTeacherType: Int? = null

    @Column(name = "name", nullable = false)
    var name: String? = null
}