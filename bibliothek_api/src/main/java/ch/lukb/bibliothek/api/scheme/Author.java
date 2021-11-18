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
    @Column(length=5012)
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public String getCurriculumVitae() {
        return curriculumVitae;
    }

    public void setCurriculumVitae(String curriculumVitae) {
        this.curriculumVitae = curriculumVitae;
    }
}
