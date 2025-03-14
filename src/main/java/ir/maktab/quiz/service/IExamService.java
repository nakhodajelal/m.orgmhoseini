package ir.maktab.quiz.service;

import ir.maktab.quiz.model.domainmodel.Exam;
import ir.maktab.quiz.model.dto.ExamDTO;
import ir.maktab.quiz.model.dto.StudentExamResultDTO;

import java.util.List;

public interface IExamService {

    List<Exam> getExamsByCourse(Long courseId, Long teacherId);
    Exam createExam(ExamDTO examDTO);
    Exam updateExam(Long examId, ExamDTO examDTO);
    void deleteExam(Long examId);
    List<StudentExamResultDTO> getExamResults(Long examId);
}
