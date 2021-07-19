package ch.lukb.bibliothek.api.service;

import ch.lukb.bibliothek.api.dao.AbstractDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class AbstractService<T>{

    AbstractDAO<T> dao;

    public List<T> getAll() {
        return dao.findAll();
    }

    public T get(Long id) {
        return dao.findOne(id);
    }

    public T add(T t) {
        T x = dao.update(t);
        return x;
    }

    public T delete(Long id) {
        try {
            return dao.findOne(id);
        } finally {
            dao.deleteById(id);
        }
    }

}