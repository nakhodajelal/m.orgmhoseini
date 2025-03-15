package ir.maktab.quiz.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentExamResultDTO {
    private String studentName;
    private Double autoGradedScore;
    private Double manualScore;
}

