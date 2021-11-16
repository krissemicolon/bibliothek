package ch.lukb.bibliothek.api.dao;

import ch.lukb.bibliothek.api.scheme.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorDAO extends AbstractDAO<Author> {
    @Override
    protected Class<Author> getClazz() {
        return Author.class;
    }
}
