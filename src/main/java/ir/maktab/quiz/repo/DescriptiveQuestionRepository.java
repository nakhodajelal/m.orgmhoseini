package ir.maktab.quiz.repo;

import ir.maktab.quiz.model.domainmodel.DescriptiveQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DescriptiveQuestionRepository extends JpaRepository<DescriptiveQuestion, Long> {
}

