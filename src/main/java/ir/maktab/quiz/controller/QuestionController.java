package ir.maktab.quiz.controller;

import ir.maktab.quiz.model.dto.QuestionDTO;
import ir.maktab.quiz.service.impl.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @PostMapping("/add/{examId}")
    public ResponseEntity<QuestionDTO> addQuestion(@PathVariable Long examId, @RequestBody QuestionDTO dto) {
        return ResponseEntity.ok(questionService.addQuestionToExam(examId, dto));
    }

    @GetMapping("/exam/{examId}")
    public ResponseEntity<List<QuestionDTO>> getQuestionsByExam(@PathVariable Long examId) {
        return ResponseEntity.ok(questionService.getQuestionsByExam(examId));
    }

    @PutMapping("/update/{questionId}")
    public ResponseEntity<QuestionDTO> updateQuestion(@PathVariable Long questionId, @RequestBody QuestionDTO dto) {
        return ResponseEntity.ok(questionService.updateQuestion(questionId, dto));
    }

    @DeleteMapping("/delete/{questionId}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long questionId) {
        questionService.deleteQuestion(questionId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/by-teacher/{teacherId}")
    public ResponseEntity<List<QuestionDTO>> getQuestionsByTeacher(@PathVariable Long teacherId) {
        return ResponseEntity.ok(questionService.getQuestionsByTeacher(teacherId));
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<QuestionDTO>> getQuestionsByCourse(@PathVariable Long courseId) {
        return ResponseEntity.ok(questionService.getQuestionsByCourse(courseId));
    }
}
