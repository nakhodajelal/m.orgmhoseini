package ir.maktab.quiz.model.dto;

import ir.maktab.quiz.model.domainmodel.StudentAnswer;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentAnswerDTO {
    private Long answerId;
    private Long sessionId;
    private Long questionId;
    private String answerText;
    private Integer selectedOptionIndex;

    public StudentAnswerDTO(StudentAnswer answer) {
        this.answerId = answer.getId();
        this.sessionId = answer.getExamSession().getId();
        this.questionId = answer.getQuestion().getId();
        this.answerText = answer.getAnswerText();
        this.selectedOptionIndex = answer.getSelectedOptionIndex();
    }
}

