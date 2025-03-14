package ir.maktab.quiz.service.impl;

import ir.maktab.quiz.model.domainmodel.Course;
import ir.maktab.quiz.model.domainmodel.User;
import ir.maktab.quiz.model.dto.CourseDTO;
import ir.maktab.quiz.model.enums.Role;
import ir.maktab.quiz.repo.CourseRepository;
import ir.maktab.quiz.repo.UserRepository;
import ir.maktab.quiz.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CourseServiceImpl implements ICourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Course createCourse(CourseDTO courseDTO) {
        Course course = new Course();
        course.setTitle(courseDTO.getTitle());
        course.setUniqueCode(courseDTO.getUniqueCode());
        course.setStartDate(courseDTO.getStartDate());
        course.setEndDate(courseDTO.getEndDate());
        return courseRepository.save(course);
    }

    @Override
    public Course assignTeacherToCourse(Long courseId, Long teacherId) {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));
        User teacher = userRepository.findById(teacherId).orElseThrow(() -> new RuntimeException("Teacher not found"));
        if (teacher.getRole() != Role.TEACHER) {
            throw new RuntimeException("User is not a teacher");
        }
        course.setTeacher(teacher);
        return courseRepository.save(course);
    }

    @Override
    public Course addStudentToCourse(Long courseId, Long studentId) {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));
        User student = userRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));
        if (student.getRole() != Role.STUDENT) {
            throw new RuntimeException("User is not a student");
        }
        course.getStudents().add(student);
        return courseRepository.save(course);
    }


    @Override
    public Course updateCourse(Long courseId, CourseDTO courseDTO) {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));
        course.setTitle(courseDTO.getTitle());
        course.setUniqueCode(courseDTO.getUniqueCode());
        course.setStartDate(courseDTO.getStartDate());
        course.setEndDate(courseDTO.getEndDate());
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long courseId) {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));
        courseRepository.delete(course);
    }

    @Override
    public List<User> getCourseParticipants(Long courseId) {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));
        List<User> participants = new ArrayList<>();
        participants.add(course.getTeacher());
        participants.addAll(course.getStudents());
        return participants;
    }



}