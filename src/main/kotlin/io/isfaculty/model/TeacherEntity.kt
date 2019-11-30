package io.isfaculty.model

import javax.persistence.*

@Entity
@Table(name = "teacher", schema = "public")
class TeacherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_teacher", unique = true, nullable = false)
    var idTeacher: Int? = null

    @OneToOne(targetEntity = TeacherTypeEntity::class)
    @JoinColumn(name = "id_teacher_type", nullable = false)
    var teacherTypeEntity: TeacherTypeEntity? = null

    @OneToOne(targetEntity = FacultyEntity::class)
    @JoinColumn(name = "id_faculty", nullable = false)
    var facultyEntity: FacultyEntity? = null

    @ManyToMany
    @JoinTable(name = "teacher_department",
            joinColumns = [JoinColumn(name = "id_teacher")],
            inverseJoinColumns = [JoinColumn(name = "id_department")])
    var teachersDepartment: Set<DepartmentEntity>? = null

}