package ir.maktab.quiz.model.dto;

import ir.maktab.quiz.model.domainmodel.MultipleChoiceQuestion;
import ir.maktab.quiz.model.domainmodel.Option;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class MultipleChoiceQuestionDTO extends QuestionDTO {

    private List<String> options;
    private Integer correctOptionIndex;

    public MultipleChoiceQuestionDTO(MultipleChoiceQuestion question) {
        super(question);
        this.options = question.getOptions().stream().map(Option::getText).toList();
        this.correctOptionIndex = question.getCorrectOptionIndex();
    }
}

