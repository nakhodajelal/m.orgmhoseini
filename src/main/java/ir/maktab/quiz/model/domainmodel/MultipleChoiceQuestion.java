package ir.maktab.quiz.model.domainmodel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("MULTIPLE_CHOICE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MultipleChoiceQuestion extends Question {

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Option> options = new ArrayList<>();
    private Integer correctOptionIndex;
}

