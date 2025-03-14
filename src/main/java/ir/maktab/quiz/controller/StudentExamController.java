package ir.maktab.quiz.controller;

import ir.maktab.quiz.model.dto.CourseDTO;
import ir.maktab.quiz.model.dto.ExamDTO;
import ir.maktab.quiz.service.IStudentExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentExamController {

    private final IStudentExamService studentExamService;

    @GetMapping("/courses/{studentId}")
    public ResponseEntity<List<CourseDTO>> getStudentCourses(@PathVariable Long studentId) {
        return ResponseEntity.ok(studentExamService.getStudentCourses(studentId));
    }

//    @GetMapping("/exams/{studentId}/{courseId}")
//    public ResponseEntity<List<ExamDTO>> getAvailableExams(@PathVariable Long studentId, @PathVariable Long courseId) {
//        return ResponseEntity.ok(studentExamService.getAvailableExams(studentId, courseId));
//    }


}

