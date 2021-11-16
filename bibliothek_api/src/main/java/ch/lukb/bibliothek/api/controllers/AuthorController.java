package ch.lukb.bibliothek.api.controllers;

import ch.lukb.bibliothek.api.scheme.Author;
import ch.lukb.bibliothek.api.service.AuthorService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5000")
public class AuthorController implements ControllerInterface<Author> {
    private AuthorService authorService;

    public AuthorController() {}

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @Override
    @GetMapping("/authors")
    public List<Author> getAll() {
        return authorService.getAll();
    }

    @Override
    @GetMapping("/author/{id}")
    public Author get(Long id) {
        return authorService.get(id);
    }

    @Override
    @PostMapping("/author")
    public Author add(Author author) {
        return authorService.add(author);
    }

    @Override
    @DeleteMapping("/author/{id}")
    public Author delete(Long id) {
        return authorService.delete(id);
    }
}
