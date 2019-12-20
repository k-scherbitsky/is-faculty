package io.isfaculty.converter

import io.isfaculty.dto.ExamTestSerachResponse
import io.isfaculty.dto.FullTeacher
import io.isfaculty.model.GradeEntity
import io.isfaculty.model.TeacherEntity
import org.springframework.stereotype.Component
import java.text.SimpleDateFormat

@Component
class GradeConverter {

    private val sdf = SimpleDateFormat("dd-MM-yyyy")

    fun convert(entity: GradeEntity?): ExamTestSerachResponse? {
        return ExamTestSerachResponse(
                entity?.studentEntity?.idStudent,
                entity?.studentEntity?.groupEntity?.name,
                entity?.studentEntity?.humanEntity?.firstName,
                entity?.studentEntity?.humanEntity?.lastName,
                entity?.studyPlanEntity?.disciplineEntity?.name,
                entity?.studyPlanEntity?.occupationTypeEntity?.name,
                entity?.grade
        )
    }
}