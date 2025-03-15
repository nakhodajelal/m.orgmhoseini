package ir.maktab.quiz.service.impl;

import ir.maktab.quiz.model.domainmodel.DescriptiveQuestion;
import ir.maktab.quiz.model.domainmodel.StudentAnswer;
import ir.maktab.quiz.repo.ExamQuestionRepository;
import ir.maktab.quiz.repo.StudentAnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExamManualGradingService {

    private final StudentAnswerRepository studentAnswerRepository;
    private final ExamQuestionRepository examQuestionRepository;

   // phase E:The teacher can give grades to the descriptive questions.
    public void gradeDescriptiveAnswer(Long studentAnswerId, Double score) {
        StudentAnswer studentAnswer = studentAnswerRepository.findById(studentAnswerId)
                .orElseThrow(() -> new RuntimeException("Student answer not found"));

        if (!(studentAnswer.getQuestion() instanceof DescriptiveQuestion)) {
            throw new RuntimeException("This question is not descriptive");
        }


        Double maxScore = examQuestionRepository.findDefaultScoreByExamAndQuestion(
                studentAnswer.getExamSession().getExam().getId(),
                studentAnswer.getQuestion().getId());

        if (maxScore == null) {
            throw new RuntimeException("Default score is not set for this question");
        }

        if (score > maxScore) {
            throw new RuntimeException("Score cannot be greater than the default score");
        }

        studentAnswer.setManualScore(score);
        studentAnswerRepository.save(studentAnswer);
    }

}

