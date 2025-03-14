package ir.maktab.quiz.model.domainmodel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@DiscriminatorValue("DESCRIPTIVE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DescriptiveQuestion extends Question {

    private String answerGuide;
}
