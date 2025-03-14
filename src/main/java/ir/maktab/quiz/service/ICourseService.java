package ir.maktab.quiz.service;

import ir.maktab.quiz.model.domainmodel.Course;
import ir.maktab.quiz.model.domainmodel.User;
import ir.maktab.quiz.model.dto.CourseDTO;
import ir.maktab.quiz.model.dto.UserDTO;

import java.util.List;


public interface ICourseService {
    Course createCourse(CourseDTO courseDTO);
    Course assignTeacherToCourse(Long courseId, Long teacherId);
    Course addStudentToCourse(Long courseId, Long studentId);
    Course updateCourse(Long courseId, CourseDTO courseDTO);
    void deleteCourse(Long courseId);
    List<User> getCourseParticipants(Long courseId);

}



