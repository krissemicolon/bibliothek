package ch.lukb.bibliothek.api.dao;

import ch.lukb.bibliothek.api.scheme.Book;
import org.springframework.stereotype.Component;

@Component
public class BookDAO extends AbstractDAO<Book> {

    @Override
    protected Class<Book> getClazz() {
        return Book.class;
    }

}
