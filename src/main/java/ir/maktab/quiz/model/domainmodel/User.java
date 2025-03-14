package ir.maktab.quiz.model.domainmodel;

import ir.maktab.quiz.model.base.BaseEntity;
import ir.maktab.quiz.model.enums.Role;
import ir.maktab.quiz.model.enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "PERSONS")
@Data
@NoArgsConstructor
public class User extends BaseEntity {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Enumerated(EnumType.STRING)
    private Status status;

}
