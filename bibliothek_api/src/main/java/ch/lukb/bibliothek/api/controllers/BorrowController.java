package ch.lukb.bibliothek.api.controllers;

import ch.lukb.bibliothek.api.scheme.Borrow;
import ch.lukb.bibliothek.api.service.BorrowService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BorrowController implements ControllerInterface<Borrow> {

    private BorrowService borrowService;

    public BorrowController(BorrowService borrowService) {
        this.borrowService = borrowService;
    }

    @Override
    @GetMapping("/borrows")
    public List<Borrow> getAll() {
        return borrowService.getAll();
    }

    @Override
    @GetMapping("/borrow/{id}")
    public Borrow get(Long id) {
        return borrowService.get(id);
    }

    @Override
    @PostMapping("/borrow")
    public Borrow add(Borrow borrow) {
        return borrowService.add(borrow);
    }

    @Override
    @DeleteMapping("/borrow/{id}")
    public Borrow delete(Long id) {
        return borrowService.delete(id);
    }

}