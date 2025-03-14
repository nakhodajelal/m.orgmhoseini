package ir.maktab.quiz.service;

import ir.maktab.quiz.model.dto.ExamQuestionDTO;

public interface IExamQuestionService {


    void setQuestionScore(Long examId, ExamQuestionDTO dto);
    Double getTotalExamScore(Long examId);

}
