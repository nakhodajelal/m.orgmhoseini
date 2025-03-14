package ir.maktab.quiz.repo;

import ir.maktab.quiz.model.domainmodel.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {


    List<Course> findByStudentsId(Long studentId);
}

