package ir.maktab.quiz.controller;

import ir.maktab.quiz.model.dto.ExamDTO;
import ir.maktab.quiz.model.dto.StudentExamResultDTO;
import ir.maktab.quiz.service.IExamService;
import ir.maktab.quiz.model.domainmodel.Exam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exams")
public class ExamController {

    @Autowired
    private IExamService examService;

    @GetMapping("/course/{courseId}/teacher/{teacherId}")
    public ResponseEntity<List<ExamDTO>> getExamsByCourse(@PathVariable Long courseId, @PathVariable Long teacherId) {
        List<Exam> exams = examService.getExamsByCourse(courseId, teacherId);
        return ResponseEntity.ok(exams.stream().map(ExamDTO::new).toList());
    }

    @PostMapping("/create")
    public ResponseEntity<ExamDTO> createExam(@RequestBody ExamDTO examDTO) {
        Exam exam = examService.createExam(examDTO);
        return ResponseEntity.ok(new ExamDTO(exam));
    }

    @PutMapping("/{examId}/update")
    public ResponseEntity<ExamDTO> updateExam(@PathVariable Long examId, @RequestBody ExamDTO examDTO) {
        Exam exam = examService.updateExam(examId, examDTO);
        return ResponseEntity.ok(new ExamDTO(exam));
    }

    @DeleteMapping("/{examId}/delete")
    public ResponseEntity<Void> deleteExam(@PathVariable Long examId) {
        examService.deleteExam(examId);
        return ResponseEntity.noContent().build();
    }


}
