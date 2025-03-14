package ir.maktab.quiz.service.impl;

import ir.maktab.quiz.service.IExamQuestionService;
import ir.maktab.quiz.model.domainmodel.*;
import ir.maktab.quiz.model.dto.ExamQuestionDTO;
import ir.maktab.quiz.repo.ExamQuestionRepository;
import ir.maktab.quiz.repo.ExamRepository;
import ir.maktab.quiz.repo.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ExamQuestionService implements IExamQuestionService {

    private final ExamQuestionRepository examQuestionRepository;
    private final ExamRepository examRepository;
    private final QuestionRepository questionRepository;

    @Transactional
    @Override
    public void setQuestionScore(Long examId, ExamQuestionDTO dto) {
        Exam exam = examRepository.findById(examId)
                .orElseThrow(() -> new RuntimeException("Exam not found"));

        Question question = questionRepository.findById(dto.getQuestionId())
                .orElseThrow(() -> new RuntimeException("Question not found"));

        ExamQuestion examQuestion = examQuestionRepository.findByExamAndQuestion(exam, question)
                .orElse(new ExamQuestion(exam, question, dto.getDefaultScore()));

        examQuestion.setDefaultScore(dto.getDefaultScore());
        examQuestionRepository.save(examQuestion);
    }
    @Override
    public Double getTotalExamScore(Long examId) {
        return examQuestionRepository.getTotalScoreByExamId(examId).orElse(0.0);
    }
}


