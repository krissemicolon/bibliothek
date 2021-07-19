package ch.lukb.bibliothek.api.controllers;

import ch.lukb.bibliothek.api.scheme.BookOrder;
import ch.lukb.bibliothek.api.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5000")
public class OrderController implements ControllerInterface<BookOrder> {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    @GetMapping("/orders")
    public List<BookOrder> getAll() {
        return orderService.getAll();
    }

    @Override
    @GetMapping("/order/{id}")
    public BookOrder get(Long id) {
        return orderService.get(id);
    }

    @Override
    @PostMapping("/order")
    public BookOrder add(BookOrder order) {
        return orderService.add(order);
    }

    @Override
    @DeleteMapping("/order/{id}")
    public BookOrder delete(Long id) {
        return orderService.delete(id);
    }
}