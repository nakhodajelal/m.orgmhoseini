package ir.maktab.quiz.model.dto;

import ir.maktab.quiz.model.domainmodel.ExamSession;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamSessionDTO {
    private Long sessionId;
    private Long studentId;
    private Long examId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Boolean isFinished;
    private List<StudentAnswerDTO> answers;

    public ExamSessionDTO(ExamSession session) {
        this.sessionId = session.getId();
        this.studentId = session.getStudent().getId();
        this.examId = session.getExam().getId();
        this.startTime = session.getStartTime();
        this.endTime = session.getEndTime();
        this.isFinished = session.getIsFinished();
        this.answers = session.getAnswers().stream().map(StudentAnswerDTO::new).collect(Collectors.toList());
    }
}

