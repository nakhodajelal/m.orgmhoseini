package ir.maktab.quiz.repo;

import ir.maktab.quiz.model.domainmodel.User;
import ir.maktab.quiz.model.enums.Role;
import ir.maktab.quiz.model.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByRole(Role role);

    List<User> findByStatus(Status status);

    List<User> findByRoleAndFirstNameContainingAndLastNameContaining(Role role, String firstName, String lastName);
// List<User> findByRoleAndFirstNameContainingAndLastNameContaining(String role, String firstName, String lastName);

//    List<User> findByRoleAndFirstNameAndLastNameContaining(String firstName, String lastName);
}


