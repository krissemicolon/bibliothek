package ch.lukb.bibliothek.api.dao;

import ch.lukb.bibliothek.api.scheme.Borrow;
import ch.lukb.bibliothek.api.scheme.Example;
import org.springframework.stereotype.Component;

@Component
public class ExampleDAO extends AbstractDAO<Example> {
    @Override
    protected Class<Example> getClazz() {
        return Example.class;
    }
}
