package io.isfaculty.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "group", schema = "public")
class GroupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_group", unique = true, nullable = false)
    var idGroup: Int? = null

    @ManyToOne(targetEntity = FacultyEntity::class)
    @JoinColumn(name = "id_faculty", nullable = false)
    var facultyEntity: FacultyEntity? = null

    @ManyToOne(targetEntity = DepartmentEntity::class)
    @JoinColumn(name = "id_department", nullable = false)
    var departmentEntity: DepartmentEntity? = null

    @OneToOne(targetEntity = StudentEntity::class)
    @JoinColumn(name = "id_headman", referencedColumnName = "id_student")
    var headmanEntity: StudentEntity? = null

    @Column(name = "name", nullable = false)
    var name: String? = null

    @Column(name = "created_date", nullable = false)
    var createdDate: Date? = null



}