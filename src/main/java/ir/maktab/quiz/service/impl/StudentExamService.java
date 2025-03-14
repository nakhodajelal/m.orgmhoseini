package ir.maktab.quiz.service.impl;

import ir.maktab.quiz.service.IStudentExamService;
import ir.maktab.quiz.model.dto.CourseDTO;
import ir.maktab.quiz.repo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentExamService implements IStudentExamService {
    private final CourseRepository courseRepository;
    private final ExamRepository examRepository;

    private final UserRepository userRepository;

    public List<CourseDTO> getStudentCourses(Long studentId) {
//        return courseRepository.findByStudents_Id(studentId)
//                .stream()
//                .map(CourseDTO::new)
//                .collect(Collectors.toList());
        return courseRepository.findByStudentsId(studentId)
                .stream()
                .map(course -> new CourseDTO(course))
                .collect(Collectors.toList());
    }

}
