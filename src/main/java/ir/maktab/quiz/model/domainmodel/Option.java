package ir.maktab.quiz.model.domainmodel;
import ir.maktab.quiz.model.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "options")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Option extends BaseEntity {

    private String text;
    @ManyToOne
    @JoinColumn(name = "question_id")
    private MultipleChoiceQuestion question;
}
