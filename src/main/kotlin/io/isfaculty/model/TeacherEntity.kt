package io.isfaculty.model

import javax.persistence.*

@Entity
@Table(name = "teacher", schema = "public")
class TeacherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_teacher", unique = true, nullable = false)
    var idTeacher: Int? = null

    @ManyToOne(targetEntity = TeacherTypeEntity::class, cascade = [CascadeType.ALL])
    @JoinColumn(name = "id_teacher_type", nullable = false)
    var teacherTypeEntity: TeacherTypeEntity? = null

    @OneToOne(targetEntity = HumanEntity::class, cascade = [CascadeType.ALL])
    @JoinColumn(name = "id_human", referencedColumnName = "id_human")
    var humanEntity: HumanEntity? = null

    @ManyToMany
    @JoinTable(name = "teacher_department",
            joinColumns = [JoinColumn(name = "id_teacher")],
            inverseJoinColumns = [JoinColumn(name = "id_department")])
    var teachersDepartment: List<DepartmentEntity>? = null

}