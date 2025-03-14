package ir.maktab.quiz.repo;

import ir.maktab.quiz.model.domainmodel.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {

    List<Exam> findByCourseIdAndTeacherId(Long courseId, Long teacherId);

    List<Exam> findByCourseId(Long courseId);


}