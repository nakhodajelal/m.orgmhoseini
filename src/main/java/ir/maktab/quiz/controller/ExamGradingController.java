package ir.maktab.quiz.controller;

import ir.maktab.quiz.service.impl.ExamGradingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/teacher/exams")
@RequiredArgsConstructor
public class ExamGradingController {

    private final ExamGradingService examGradingService;

    @GetMapping("/{examId}/auto-grade")
    public ResponseEntity<String> autoGradeExam(@PathVariable Long examId) {
        examGradingService.autoGradeExam(examId);
        return ResponseEntity.ok("نمرات محاسبه و ذخیره شدند.");
    }
}

