package ir.maktab.quiz.controller;

import ir.maktab.quiz.model.dto.ExamSessionDTO;
import ir.maktab.quiz.model.dto.StudentAnswerDTO;
import ir.maktab.quiz.service.impl.ExamSessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exam-session")
@RequiredArgsConstructor
public class ExamSessionController {

    private final ExamSessionService examSessionService;

    @PostMapping("/start/{studentId}/{examId}")
    public ResponseEntity<ExamSessionDTO> startExam(@PathVariable Long studentId, @PathVariable Long examId) {
        return ResponseEntity.ok(examSessionService.startExam(studentId, examId));
    }

    @PostMapping("/submit-answer/{sessionId}/{questionId}")
    public ResponseEntity<Void> submitAnswer(
            @PathVariable Long sessionId,
            @PathVariable Long questionId,
            @RequestBody StudentAnswerDTO dto) {

        examSessionService.submitAnswer(sessionId, questionId, dto.getAnswerText(), dto.getSelectedOptionIndex());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/finish/{sessionId}")
    public ResponseEntity<Void> finishExam(@PathVariable Long sessionId) {
        examSessionService.finishExam(sessionId);
        return ResponseEntity.ok().build();
    }
}

