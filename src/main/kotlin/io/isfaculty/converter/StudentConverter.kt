package io.isfaculty.converter

import io.isfaculty.dto.Student
import io.isfaculty.model.StudentEntity
import org.springframework.stereotype.Component
import java.text.SimpleDateFormat

@Component
class StudentConverter {

    fun convert(entity: StudentEntity): Student {

        val sdf = SimpleDateFormat("dd-MM-yyyy")

        return Student(
                entity.idStudent,
                entity.humanEntity?.firstName,
                entity.humanEntity?.lastName,
                entity.humanEntity?.middleName,
                sdf.format(entity.humanEntity?.birthDate),
                entity.humanEntity?.phoneNumber,
                entity.humanEntity?.email,
                entity.idRecordBook,
                entity.studyFormEntity?.name,
                sdf.format(entity.admissionDate),
                entity.groupEntity?.name,
                entity.hasChildren,
                entity.humanEntity?.sex
        )
    }

}