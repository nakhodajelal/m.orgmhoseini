package ir.maktab.quiz.repo;

import ir.maktab.quiz.model.domainmodel.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByTeacherId(Long teacherId);
    List<Question> findByExamId(Long examId);
    List<Question> findByCourseId(Long examId);
}

