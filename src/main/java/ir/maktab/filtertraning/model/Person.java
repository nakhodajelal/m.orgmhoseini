package ir.maktab.filtertraning.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Person extends BaseEntity<Long> {

    private String username;
    private String password;
    private String nationalCode;

}
