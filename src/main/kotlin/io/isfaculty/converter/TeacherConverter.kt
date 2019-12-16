package io.isfaculty.converter

import io.isfaculty.dto.FullTeacher
import io.isfaculty.model.TeacherEntity
import org.springframework.stereotype.Component
import java.text.SimpleDateFormat

@Component
class TeacherConverter {

    private val sdf = SimpleDateFormat("dd-MM-yyyy")

    fun convertFull(entity: TeacherEntity?): FullTeacher? {
        return FullTeacher(
                entity?.idTeacher,
                entity?.humanEntity?.firstName,
                entity?.humanEntity?.lastName,
                entity?.humanEntity?.middleName,
                entity?.humanEntity?.sex,
                sdf.format(entity?.humanEntity?.birthDate),
                entity?.humanEntity?.phoneNumber,
                entity?.humanEntity?.email,
                entity?.teacherTypeEntity?.name,
                entity?.teachersDepartment?.map { it.name.toString() },
                entity?.humanEntity?.addressList
        )
    }
}