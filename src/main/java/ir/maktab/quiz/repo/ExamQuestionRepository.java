package ir.maktab.quiz.repo;

import ir.maktab.quiz.model.domainmodel.Exam;
import ir.maktab.quiz.model.domainmodel.ExamQuestion;
import ir.maktab.quiz.model.domainmodel.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ExamQuestionRepository extends JpaRepository<ExamQuestion, Long> {

    Optional<ExamQuestion> findByExamAndQuestion(Exam exam, Question question);

    @Query("SELECT SUM(eq.defaultScore) FROM ExamQuestion eq WHERE eq.exam.id = :examId")
    Optional<Double> getTotalScoreByExamId(Long examId);


    @Query("SELECT eq.defaultScore FROM ExamQuestion eq WHERE eq.exam.id = :examId AND eq.question.id = :questionId")
    Double findDefaultScoreByExamAndQuestion(@Param("examId") Long examId, @Param("questionId") Long questionId);
}
