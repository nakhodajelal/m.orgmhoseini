package ir.maktab.quiz.controller;

import ir.maktab.quiz.model.domainmodel.Course;
import ir.maktab.quiz.model.domainmodel.User;
import ir.maktab.quiz.model.dto.CourseDTO;
import ir.maktab.quiz.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private ICourseService courseService;


    @PostMapping("/create")
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO courseDTO) {
        Course course = courseService.createCourse(courseDTO);
        return ResponseEntity.ok(new CourseDTO(course));
    }


    @PutMapping("/{courseId}/assign-teacher/{teacherId}")
    public ResponseEntity<CourseDTO> assignTeacher(@PathVariable Long courseId, @PathVariable Long teacherId) {
        Course course = courseService.assignTeacherToCourse(courseId, teacherId);
        return ResponseEntity.ok(new CourseDTO(course));
    }


    @PutMapping("/{courseId}/add-student/{studentId}")
    public ResponseEntity<CourseDTO> addStudent(@PathVariable Long courseId, @PathVariable Long studentId) {
        Course course = courseService.addStudentToCourse(courseId, studentId);
        return ResponseEntity.ok(new CourseDTO(course));
    }

    @PutMapping("/{courseId}/update")
    public ResponseEntity<CourseDTO> updateCourse(@PathVariable Long courseId, @RequestBody CourseDTO courseDTO) {
        Course course = courseService.updateCourse(courseId, courseDTO);
        return ResponseEntity.ok(new CourseDTO(course));
    }

    @DeleteMapping("/{courseId}/delete")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long courseId) {
        courseService.deleteCourse(courseId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{courseId}/participants")
    public ResponseEntity<List<User>> getCourseParticipants(@PathVariable Long courseId) {
        List<User> participants = courseService.getCourseParticipants(courseId);
        return ResponseEntity.ok(participants);
    }
}
