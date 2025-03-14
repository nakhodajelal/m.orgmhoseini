package ir.maktab.quiz.model.dto;

import ir.maktab.quiz.model.domainmodel.User;
import ir.maktab.quiz.model.enums.Role;
import ir.maktab.quiz.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Role role;
    private Status status;

    public UserDTO(User user){
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.role = user.getRole();
        this.status = user.getStatus();
    }

}
