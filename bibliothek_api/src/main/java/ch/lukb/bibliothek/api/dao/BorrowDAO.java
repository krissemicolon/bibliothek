package ch.lukb.bibliothek.api.dao;

import ch.lukb.bibliothek.api.scheme.Borrow;
import org.springframework.stereotype.Component;

@Component
public class BorrowDAO extends AbstractDAO<Borrow> {
    @Override
    protected Class<Borrow> getClazz() {
        return Borrow.class;
    }
}
