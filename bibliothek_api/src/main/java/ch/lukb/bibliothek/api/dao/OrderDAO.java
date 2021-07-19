package ch.lukb.bibliothek.api.dao;

import ch.lukb.bibliothek.api.scheme.BookOrder;
import org.springframework.stereotype.Component;

@Component
public class OrderDAO extends AbstractDAO<BookOrder>{
    @Override
    protected Class<BookOrder> getClazz() {
        return BookOrder.class;
    }
}
