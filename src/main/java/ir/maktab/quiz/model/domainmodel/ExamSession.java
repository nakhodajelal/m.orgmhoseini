package ir.maktab.quiz.model.domainmodel;

import ir.maktab.quiz.model.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "exam_sessions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamSession extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private User student;

    @ManyToOne
    @JoinColumn(name = "exam_id", nullable = false)
    private Exam exam;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Boolean isFinished = false;

    @OneToMany(mappedBy = "examSession", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StudentAnswer> answers = new ArrayList<>();

    public ExamSession(User student, Exam exam) {
        this.student = student;
        this.exam = exam;
        this.startTime = LocalDateTime.now();
        this.endTime = startTime.plusMinutes(exam.getDurationMinutes());
    }
}

