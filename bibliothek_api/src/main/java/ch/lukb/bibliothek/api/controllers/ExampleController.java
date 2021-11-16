package ch.lukb.bibliothek.api.controllers;

import ch.lukb.bibliothek.api.scheme.Example;
import ch.lukb.bibliothek.api.service.ExampleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5000")
public class ExampleController implements ControllerInterface<Example> {
    private ExampleService exampleService;

    public ExampleController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @Override
    @GetMapping("/examples")
    public List<Example> getAll() {
        return exampleService.getAll();
    }

    @Override
    @GetMapping("/example{id}")
    public Example get(Long id) {
        return exampleService.get(id);
    }

    @Override
    @PostMapping("/example")
    public Example add(Example example) {
        return exampleService.add(example);
    }

    @Override
    @DeleteMapping("/example/{id}")
    public Example delete(Long id) {
        return exampleService.delete(id);
    }
}
