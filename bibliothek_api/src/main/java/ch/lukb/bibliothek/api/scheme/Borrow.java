package ch.lukb.bibliothek.api.scheme;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date borrowDate;
    private Date returnDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private List<Book> books;

    public Borrow() {}

    public Borrow(Customer customer, List<Book> books, Date returnDate) {
        this.customer = customer;
        this.books = books;
        this.returnDate = returnDate;
        this.borrowDate = Calendar.getInstance().getTime();
    }

    public List<Book> getBook() {
        return books;
    }

    public void setBook(List<Book> books) {
        this.books = books;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
