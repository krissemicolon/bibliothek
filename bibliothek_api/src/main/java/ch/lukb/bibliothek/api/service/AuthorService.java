package ch.lukb.bibliothek.api.service;

import ch.lukb.bibliothek.api.dao.AbstractDAO;
import ch.lukb.bibliothek.api.scheme.Author;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class AuthorService extends AbstractService<Author> {
    public AuthorService(AbstractDAO<Author> dao) {
        dao.update(
                new Author(
                        "Kris",
                        "Huber",
                        LocalDate.of(2004, 4, 21),
                        ""
                )
        );

        this.dao = dao;
    }
}
