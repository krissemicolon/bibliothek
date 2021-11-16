package ch.lukb.bibliothek.api.scheme;

import javax.persistence.*;
import javax.swing.plaf.IconUIResource;
import java.time.LocalDate;
import java.time.Period;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private short age;
    private String curriculumVitae;

    public Author() {}

    public Author(String firstName, String lastName, LocalDate birthDate, String curriculumVitae) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.curriculumVitae = curriculumVitae;
        updateAge();
    }

    public void updateAge() {
        this.age = (short)Period.between(birthDate, LocalDate.now()).getYears();
    }
}
