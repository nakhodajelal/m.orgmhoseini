package ir.maktab.quiz.model.domainmodel;

import ir.maktab.quiz.model.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "exam_questions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamQuestion extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "exam_id", nullable = false)
    private Exam exam;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    private Double defaultScore;
}
