package ir.maktab.quiz.model.domainmodel;

import ir.maktab.quiz.model.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "questions")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "question_type")
@NoArgsConstructor
@AllArgsConstructor
public abstract class Question extends BaseEntity {


    private String title;
    private String text;
    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private User teacher;
    @ManyToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

}
