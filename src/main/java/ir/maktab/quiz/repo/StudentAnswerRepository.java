package ir.maktab.quiz.repo;

import ir.maktab.quiz.model.domainmodel.ExamSession;
import ir.maktab.quiz.model.domainmodel.StudentAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentAnswerRepository extends JpaRepository<StudentAnswer,Long> {

    List<StudentAnswer> findByExamSession(ExamSession examSession);
    Optional<StudentAnswer> findByExamSessionIdAndQuestionId(Long sessionId, Long questionId);

    List<StudentAnswer> findByExamSessionId(Long examSessionId);
}
