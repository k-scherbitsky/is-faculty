package io.isfaculty.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "department", schema = "public")
class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_department", unique = true, nullable = false)
    var idDepartment: Int? = null

    @ManyToOne(targetEntity = FacultyEntity::class)
    @JoinColumn(name = "id_faculty", nullable = false)
    var facultyEntity: FacultyEntity? = null

    @Column(name = "name", nullable = false)
    var name: String? = null

    @ManyToMany(mappedBy = "teachersDepartment")
    var teachers: Set<TeacherEntity>? = null
}