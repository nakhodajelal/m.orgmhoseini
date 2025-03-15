package ir.maktab.quiz.controller;

import ir.maktab.quiz.model.domainmodel.StudentAnswer;
import ir.maktab.quiz.service.impl.ExamManualGradingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/teacher/exams")
@RequiredArgsConstructor
public class ExamManualGradingController {

    private final ExamManualGradingService gradingService;

    @PutMapping("/grade/{answerId}")
    public ResponseEntity<String> gradeDescriptiveAnswer(@PathVariable Long answerId, @RequestBody StudentAnswer studentAnswer) {
        gradingService.gradeDescriptiveAnswer(answerId, studentAnswer.getScore());
        return ResponseEntity.ok("نمره با موفقیت ثبت شد.");
    }
}

