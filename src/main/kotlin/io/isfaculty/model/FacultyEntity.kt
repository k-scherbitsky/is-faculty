package io.isfaculty.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "faculty", schema = "public")
class FacultyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_faculty", unique = true, nullable = false)
    var idFaculty: Int? = null

    @Column(name = "name", nullable = false)
    var name: String? = null
}