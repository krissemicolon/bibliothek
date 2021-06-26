package ch.lukb.bibliothek.api.service;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ServiceInterface<T> {
    public List<T> getAll();

    public T get(Long id);

    public T add(T t);

    public T delete(Long id);
}
