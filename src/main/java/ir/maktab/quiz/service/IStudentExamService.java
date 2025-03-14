package ir.maktab.quiz.service;

import ir.maktab.quiz.model.dto.CourseDTO;
import ir.maktab.quiz.model.dto.ExamDTO;

import java.util.List;

public interface IStudentExamService {

    List<CourseDTO> getStudentCourses(Long studentId);
//    List<ExamDTO> getAvailableExams(Long studentId, Long courseId);
//    ExamAttemptDTO startExam(Long studentId, Long examId);

}
