package ch.lukb.bibliothek.api.controllers;

import ch.lukb.bibliothek.api.scheme.Book;
import ch.lukb.bibliothek.api.service.BookService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5000")
public class BookController implements ControllerInterface<Book> {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    @GetMapping("/books")
    public List<Book> getAll() {
        return bookService.getAll();
    }

    @Override
    @GetMapping("/book/{id}")
    public Book get(Long id) {
        return bookService.get(id);
    }

    @Override
    @PostMapping("/book")
    public Book add(Book book) {
        return bookService.add(book);
    }

    @Override
    @DeleteMapping("/book/{id}")
    public Book delete(Long id) {
        return bookService.delete(id);
    }

    @GetMapping(value = "/book/{id}/image", produces = MediaType.IMAGE_JPEG_VALUE)
    public void getImage(HttpServletResponse response, @PathVariable long id) throws IOException {
        var imgFile = new ClassPathResource(bookService.getImagePath(id));
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(imgFile.getInputStream(), response.getOutputStream());
    }

}