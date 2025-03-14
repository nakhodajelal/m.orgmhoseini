package ir.maktab.quiz.model.dto;

import ir.maktab.quiz.model.domainmodel.Exam;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExamDTO {

    private Long id;
    private String title;
    private String description;
    private Integer durationMinutes;
    private Long courseId;
    private Long teacherId;

    public ExamDTO(Exam exam) {
        this.id = exam.getId();
        this.title = exam.getTitle();
        this.description = exam.getDescription();
        this.durationMinutes = exam.getDurationMinutes();
        this.courseId = exam.getCourse().getId();
        this.teacherId = exam.getTeacher().getId();
    }
}
