package ir.maktab.quiz.repo;

import ir.maktab.quiz.model.domainmodel.Exam;
import ir.maktab.quiz.model.domainmodel.ExamSession;
import ir.maktab.quiz.model.domainmodel.User;
import ir.maktab.quiz.model.dto.StudentExamResultDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExamSessionRepository extends JpaRepository<ExamSession,Long> {
    Optional<ExamSession> findByStudentAndExam(User student, Exam exam);
    boolean existsByStudentIdAndExamIdAndIsFinishedFalse(Long studentId, Long examId);

    List<ExamSession> findByExamIdAndIsFinishedTrue(Long examId);

}
