package ir.maktab.quiz.service.impl;

import ir.maktab.quiz.model.domainmodel.ExamSession;
import ir.maktab.quiz.model.domainmodel.MultipleChoiceQuestion;
import ir.maktab.quiz.model.domainmodel.StudentAnswer;
import ir.maktab.quiz.repo.ExamQuestionRepository;
import ir.maktab.quiz.repo.ExamSessionRepository;
import ir.maktab.quiz.repo.StudentAnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExamGradingService {

    private final ExamSessionRepository examSessionRepository;
    private final StudentAnswerRepository studentAnswerRepository;
    private final ExamQuestionRepository examQuestionRepository;


    //phase E:Calculating multiple-choice scores after the test is over
    public void autoGradeExam(Long examSessionId) {
        ExamSession examSession = examSessionRepository.findById(examSessionId)
                .orElseThrow(() -> new RuntimeException("Exam session not found"));

        List<StudentAnswer> studentAnswers = studentAnswerRepository.findByExamSessionId(examSessionId);

        for (StudentAnswer answer : studentAnswers) {
            if (answer.getQuestion() instanceof MultipleChoiceQuestion) {
                MultipleChoiceQuestion question = (MultipleChoiceQuestion) answer.getQuestion();
                if (answer.getSelectedOptionIndex() != null &&
                        answer.getSelectedOptionIndex().equals(question.getCorrectOptionIndex())) {


                    Double defaultScore = examQuestionRepository.findDefaultScoreByExamAndQuestion(
                            examSession.getExam().getId(), question.getId());

                    if (defaultScore != null) {
                        answer.setScore(defaultScore);
                    } else {
                        answer.setScore(0.0);
                    }
                } else {
                    answer.setScore(0.0);
                }
                studentAnswerRepository.save(answer);
            }
        }
    }


}

