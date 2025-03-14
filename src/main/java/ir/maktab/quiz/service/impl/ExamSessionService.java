package ir.maktab.quiz.service.impl;

import ir.maktab.quiz.model.domainmodel.*;
import ir.maktab.quiz.model.dto.ExamSessionDTO;
import ir.maktab.quiz.repo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ExamSessionService {

    private final ExamSessionRepository examSessionRepository;
    private final ExamRepository examRepository;
    private final UserRepository userRepository;
    private final StudentAnswerRepository studentAnswerRepository;
    private final QuestionRepository questionRepository;

    public ExamSessionDTO startExam(Long studentId, Long examId) {
        if (examSessionRepository.existsByStudentIdAndExamIdAndIsFinishedFalse(studentId, examId)) {
            throw new RuntimeException("The test has already started!!");
        }

        Exam exam = examRepository.findById(examId)
                .orElseThrow(() -> new RuntimeException("Test not found!"));

        User student = userRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found!"));

        ExamSession session = new ExamSession(student, exam);
        session = examSessionRepository.save(session);

        return new ExamSessionDTO(session);
    }

    public void submitAnswer(Long sessionId, Long questionId, String answerText, Integer selectedOptionIndex) {
        ExamSession session = examSessionRepository.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Test session not found!!"));

        if (LocalDateTime.now().isAfter(session.getEndTime())) {
            throw new RuntimeException("The test time is over.!");
        }

        StudentAnswer answer = studentAnswerRepository.findByExamSessionIdAndQuestionId(sessionId, questionId)
                .orElse(new StudentAnswer());
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new RuntimeException("Question not found"));
        answer.setExamSession(session);
        answer.setQuestion(question);
        answer.setAnswerText(answerText);
        answer.setSelectedOptionIndex(selectedOptionIndex);

        studentAnswerRepository.save(answer);
    }

    public void finishExam(Long sessionId) {
        ExamSession session = examSessionRepository.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Test session not found!!"));

        session.setIsFinished(true);
        examSessionRepository.save(session);
    }
}

