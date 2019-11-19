package io.isfaculty.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "discipline", schema = "public")
class DisciplineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_discipline", unique = true, nullable = false)
    var idDiscipline: Int? = null

    @Column(name = "name", nullable = false)
    var name: String? = null
}