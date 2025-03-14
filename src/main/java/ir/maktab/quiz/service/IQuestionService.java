package ir.maktab.quiz.service;

import ir.maktab.quiz.model.dto.QuestionDTO;

import java.util.List;

public interface IQuestionService {
    QuestionDTO addQuestionToExam(Long examId, QuestionDTO dto);
    List<QuestionDTO> getQuestionsByExam(Long examId);
    QuestionDTO updateQuestion(Long questionId, QuestionDTO dto);
    void deleteQuestion(Long questionId);
    List<QuestionDTO> getQuestionsByTeacher(Long teacherId);
    List<QuestionDTO> getQuestionsByCourse(Long courseId);

}
