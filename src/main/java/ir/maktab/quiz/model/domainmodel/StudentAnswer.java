package ir.maktab.quiz.model.domainmodel;

import ir.maktab.quiz.model.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;




@Entity
@Table(name = "student_answers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentAnswer extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "exam_session", nullable = false)
    private ExamSession examSession;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    private String answerText;
    private Integer selectedOptionIndex;
    private Double score;
    private Double manualScore;
}

