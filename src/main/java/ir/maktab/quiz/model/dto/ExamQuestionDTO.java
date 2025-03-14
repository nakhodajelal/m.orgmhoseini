package ir.maktab.quiz.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ExamQuestionDTO {
    private Long questionId;
    private Double defaultScore;
}
