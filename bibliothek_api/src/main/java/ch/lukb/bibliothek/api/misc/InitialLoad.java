package ch.lukb.bibliothek.api.misc;

import ch.lukb.bibliothek.api.dao.BookDAO;
import ch.lukb.bibliothek.api.dao.BorrowDAO;
import ch.lukb.bibliothek.api.dao.CustomerDAO;
import ch.lukb.bibliothek.api.dao.OrderDAO;
import ch.lukb.bibliothek.api.scheme.Book;
import ch.lukb.bibliothek.api.scheme.Borrow;
import ch.lukb.bibliothek.api.scheme.Customer;
import ch.lukb.bibliothek.api.scheme.BookOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Component
public class InitialLoad {

    /*
     *  DESC: Loads Demo data into the api on the /initial endpoint
     */

    @Autowired
    private CustomerDAO customerDAO;
    @Autowired
    private BookDAO bookDAO;
    @Autowired
    private BorrowDAO borrowDAO;
    @Autowired
    private OrderDAO orderDAO;

    public Borrow initialLoad() {
        if(bookDAO.findAll() == null || bookDAO.findAll().isEmpty()) {
            bookDAO.update(new Book("The Art of Computer Programming", "Donald E. Knuth", "static/images/The_art_of_Computer_Programming.jpg"));
            bookDAO.update(new Book("The C Programming Language", "Brian W. Kernighan, Dennis Ritchie", "static/images/The_C_Programming_Language.jpg"));
            bookDAO.update(new Book("The Implementation of Functional Programming", "Simon Peyton Jones", "static/images/The_Implementation_of_Functional_Programming.jpg"));
        }

        if(borrowDAO.findAll() == null || borrowDAO.findAll().isEmpty()) {
            Customer customer = new Customer("TestName", "test", "name", "testnam@protonmail.com");

            Book book1 = new Book("Compiler Construction", "Niklaus Wirth", "static/images/Compiler_Construction.jpg");
            Book book2 = new Book("Introduction to Algorithms", "Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest, Clifford Stein", "static/images/Introduction_to_Algorithms.jpg");

            List<Book> borrowedBooks = new ArrayList<Book>();
            borrowedBooks.add(book1);
            borrowedBooks.add(book2);

            Borrow borrow = new Borrow(customer, borrowedBooks, Calendar.getInstance().getTime());
            book1.setBorrow(borrow);

            return borrowDAO.update(borrow);
        }
        orderDAO.update(new BookOrder(3));

        return null;
    }


}
