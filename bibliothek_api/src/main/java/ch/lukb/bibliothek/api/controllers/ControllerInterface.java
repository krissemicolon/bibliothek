package ch.lukb.bibliothek.api.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface ControllerInterface<T> {

    public List<T> getAll();

    public T get(@PathVariable("id") Long id);

    public T add(@RequestBody T t);

    public T delete(@PathVariable("id") Long id);

}
