package ch.lukb.bibliothek.api.service;

import ch.lukb.bibliothek.api.dao.AbstractDAO;
import ch.lukb.bibliothek.api.scheme.Author;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.Month;

@Service
public class AuthorService extends AbstractService<Author> {
    public AuthorService(AbstractDAO<Author> dao) {
        dao.update(
            new Author(
                    "Kris",
                    "Huber",
                    LocalDate.of(2004, Month.APRIL, 21),
                    ""
            )
        );

        dao.update(
                new Author(
                        "Donald",
                        "Knuth",
                        LocalDate.of(1938, Month.JANUARY, 10),
                        ""
                )
        );

        dao.update(
                new Author(
                        "Niklaus",
                        "Wirth",
                        LocalDate.of(1934, Month.FEBRUARY, 15),
                        ""
                )
        );

        this.dao = dao;
    }
}
