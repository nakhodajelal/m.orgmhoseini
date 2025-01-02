package ir.maktab.filtertraning.model.dto;


import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotBlank;


@Data
@Builder
public class CreateUserRequest {
    @NotBlank
    private String username;
    @Length(min=5,max = 8)
    private String password;
    @Length(max=10)
    private String nationalCode;
}
