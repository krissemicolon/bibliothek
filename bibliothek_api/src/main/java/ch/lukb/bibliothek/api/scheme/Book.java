package ch.lukb.bibliothek.api.scheme;

import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String path;

    @ManyToOne
    private Borrow borrow;

    public Book() {}

    public Book(String title, String author, String path) {
        this.title = title;
        this.author = author;
        this.path = path;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPath() {
        return path;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setBorrow(Borrow borrow) {
        this.borrow = borrow;
    }

}