package ch.lukb.bibliothek.api.service;

import ch.lukb.bibliothek.api.dao.AbstractDAO;
import ch.lukb.bibliothek.api.scheme.Book;
import ch.lukb.bibliothek.api.scheme.Example;
import org.springframework.stereotype.Service;

@Service
public class ExampleService extends AbstractService<Example> {
    public ExampleService(AbstractDAO<Example> dao) {
        this.dao = dao;
    }
}