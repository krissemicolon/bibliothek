package ch.lukb.bibliothek.api.service;

import ch.lukb.bibliothek.api.dao.AbstractDAO;
import ch.lukb.bibliothek.api.scheme.Borrow;
import org.springframework.stereotype.Service;

@Service
public class BorrowService extends AbstractService<Borrow> {

    public BorrowService(AbstractDAO<Borrow> dao) {
        this.dao = dao;
    }

}
