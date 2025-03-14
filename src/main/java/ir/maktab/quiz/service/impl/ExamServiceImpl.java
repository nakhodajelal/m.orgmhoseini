package ir.maktab.quiz.service.impl;

import ir.maktab.quiz.model.domainmodel.*;
import ir.maktab.quiz.model.dto.ExamDTO;
import ir.maktab.quiz.model.dto.StudentExamResultDTO;
import ir.maktab.quiz.repo.ExamRepository;
import ir.maktab.quiz.repo.CourseRepository;
import ir.maktab.quiz.repo.ExamSessionRepository;
import ir.maktab.quiz.repo.UserRepository;
import ir.maktab.quiz.service.IExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExamServiceImpl implements IExamService {

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ExamSessionRepository examSessionRepository;

    @Override
    public List<Exam> getExamsByCourse(Long courseId, Long teacherId) {
        return examRepository.findByCourseIdAndTeacherId(courseId, teacherId);
    }

    @Override
    public Exam createExam(ExamDTO examDTO) {
        Course course = courseRepository.findById(examDTO.getCourseId()).orElseThrow(() -> new RuntimeException("Course not found"));
        User teacher = userRepository.findById(examDTO.getTeacherId()).orElseThrow(() -> new RuntimeException("Teacher not found"));
        Exam exam = new Exam();
        exam.setTitle(examDTO.getTitle());
        exam.setDescription(examDTO.getDescription());
        exam.setDurationMinutes(examDTO.getDurationMinutes());
        exam.setCourse(course);
        exam.setTeacher(teacher);
        return examRepository.save(exam);
    }

    @Override
    public Exam updateExam(Long examId, ExamDTO examDTO) {
        Exam exam = examRepository.findById(examId).orElseThrow(() -> new RuntimeException("Exam not found"));
        exam.setTitle(examDTO.getTitle());
        exam.setDescription(examDTO.getDescription());
        exam.setDurationMinutes(examDTO.getDurationMinutes());
        return examRepository.save(exam);
    }

    @Override
    public void deleteExam(Long examId) {
        examRepository.deleteById(examId);
    }



}