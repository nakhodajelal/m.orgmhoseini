package ir.maktab.filtertraning.model.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreateUserResponse {
    private Long id;
    private String username;
    private String password;
    private String nationalCode;
}
