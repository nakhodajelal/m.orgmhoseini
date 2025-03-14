package ir.maktab.quiz.model.dto;

import ir.maktab.quiz.model.domainmodel.Course;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {
    private Long id;
    private String title;
    private String uniqueCode;
    private LocalDate startDate;
    private LocalDate endDate;


    public CourseDTO(Course course) {
        this.id = course.getId();
        this.title = course.getTitle();
        this.uniqueCode = course.getUniqueCode();
        this.endDate = course.getEndDate();
        this.startDate = course.getStartDate();
    }
}
