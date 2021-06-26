package ch.lukb.bibliothek.api.service;

import ch.lukb.bibliothek.api.dao.AbstractDAO;
import ch.lukb.bibliothek.api.scheme.Book;
import org.springframework.stereotype.Service;

@Service
public class BookService extends AbstractService<Book> {

    public BookService(AbstractDAO<Book> dao) {
        this.dao = dao;
    }

    public String getImagePath(Long id) {
        return dao.findOne(id).getPath();
    }

}