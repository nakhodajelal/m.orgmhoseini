package ir.maktab.quiz.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchCriteriaDTO {
    private String keyword;
    private String role;
    private String firstName;
    private String lastName;

}

