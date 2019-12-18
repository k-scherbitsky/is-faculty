package io.isfaculty.converter

import io.isfaculty.dto.FullStudent
import io.isfaculty.dto.ScienceConf
import io.isfaculty.dto.Student
import io.isfaculty.model.ScienceConfEntity
import io.isfaculty.model.StudentEntity
import org.springframework.stereotype.Component
import java.text.SimpleDateFormat

@Component
class StudentConverter {

    private val sdf = SimpleDateFormat("dd-MM-yyyy")

    fun convert(entity: StudentEntity?): Student {
        return Student(
                entity?.idStudent,
                entity?.humanEntity?.firstName,
                entity?.humanEntity?.lastName,
                entity?.humanEntity?.middleName,
                sdf.format(entity?.humanEntity?.birthDate),
                entity?.humanEntity?.phoneNumber,
                entity?.humanEntity?.email,
                entity?.recordBook,
                entity?.studyFormEntity?.name,
                sdf.format(entity?.admissionDate),
                entity?.groupEntity?.name,
                entity?.hasChildren,
                entity?.humanEntity?.sex
        )
    }

    fun convertFull(student: StudentEntity?): FullStudent? {
        return FullStudent(
                student?.idStudent,
                student?.humanEntity?.firstName,
                student?.humanEntity?.lastName,
                student?.humanEntity?.middleName,
                student?.humanEntity?.sex,
                sdf.format(student?.humanEntity?.birthDate),
                student?.recordBook,
                student?.humanEntity?.phoneNumber,
                student?.humanEntity?.email,
                student?.groupEntity?.name,
                student?.groupEntity?.departmentEntity?.name,
                student?.groupEntity?.departmentEntity?.facultyEntity?.name,
                sdf.format(student?.admissionDate),
                student?.humanEntity?.addressList,
                student?.parents
        )
    }

    fun convertConf(entity: ScienceConfEntity): ScienceConf {
        return ScienceConf(
                entity.studentEntity?.idStudent,
                entity.studentEntity?.humanEntity?.firstName,
                entity.studentEntity?.humanEntity?.lastName,
                entity.studentEntity?.humanEntity?.middleName,
                entity.studentEntity?.groupEntity?.name,
                sdf.format(entity.createdDate),
                entity.place,
                entity.confName
        )
    }

}