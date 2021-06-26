package ch.lukb.bibliothek.api.scheme;

import ch.lukb.bibliothek.api.util.InputValidator;
import javax.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;

    @OneToOne(mappedBy = "customer")
    private Borrow borrow;

    public Customer() {}

    public Customer(String username, String firstname, String lastname, String email) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;

        if(InputValidator.validateEmail(email))
            this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
