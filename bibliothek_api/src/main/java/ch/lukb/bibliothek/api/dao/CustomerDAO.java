package ch.lukb.bibliothek.api.dao;

import ch.lukb.bibliothek.api.scheme.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerDAO extends AbstractDAO<Customer>{

    @Override
    protected Class<Customer> getClazz() {
        return Customer.class;
    }

}
