package ir.maktab.quiz.controller;

import ir.maktab.quiz.model.dto.ExamQuestionDTO;
import ir.maktab.quiz.service.IExamQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exam-questions")
@RequiredArgsConstructor
public class ExamQuestionController {

    private final IExamQuestionService examQuestionService;

    @PostMapping("/set-score/{examId}")
    public ResponseEntity<Void> setQuestionScore(@PathVariable Long examId, @RequestBody ExamQuestionDTO dto) {
        examQuestionService.setQuestionScore(examId, dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/total-score/{examId}")
    public ResponseEntity<Double> getTotalExamScore(@PathVariable Long examId) {
        return ResponseEntity.ok(examQuestionService.getTotalExamScore(examId));
    }
}
