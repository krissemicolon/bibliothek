package ch.lukb.bibliothek.api.service;

import ch.lukb.bibliothek.api.dao.AbstractDAO;
import ch.lukb.bibliothek.api.scheme.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends AbstractService<Customer> {

    public CustomerService(AbstractDAO<Customer> dao) {
        /*
        dao.update(new Customer("krissemicolon", "Kris", "Huber", "krissemicolon@gmail.com"));
         */

        this.dao = dao;
    }

}
