package ir.maktab.quiz.model.dto;

import ir.maktab.quiz.model.domainmodel.DescriptiveQuestion;
import ir.maktab.quiz.model.domainmodel.MultipleChoiceQuestion;
import ir.maktab.quiz.model.domainmodel.Question;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class QuestionDTO {

    private Long id;
    private String title;
    private String text;
    private String questionType;
    private Long teacherId;
    private String answerGuide;
    private Long courseId;


    public QuestionDTO(Question question) {
        this.id = question.getId();
        this.title = question.getTitle();
        this.text = question.getText();
        this.teacherId = question.getTeacher().getId();
        this.courseId = question.getCourse().getId();
        if (question instanceof MultipleChoiceQuestion) {
            this.questionType = "MULTIPLE_CHOICE";
        } else if (question instanceof DescriptiveQuestion) {
            this.questionType = "DESCRIPTIVE";
            this.answerGuide = ((DescriptiveQuestion) question).getAnswerGuide();
        }
    }
}
