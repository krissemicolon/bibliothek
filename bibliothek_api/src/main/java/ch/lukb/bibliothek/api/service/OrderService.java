package ch.lukb.bibliothek.api.service;

import ch.lukb.bibliothek.api.dao.AbstractDAO;
import ch.lukb.bibliothek.api.scheme.BookOrder;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends AbstractService<BookOrder> {

    public OrderService(AbstractDAO<BookOrder> dao) {
        this.dao = dao;
    }

}