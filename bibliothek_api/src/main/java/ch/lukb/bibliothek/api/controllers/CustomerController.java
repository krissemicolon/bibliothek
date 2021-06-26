package ch.lukb.bibliothek.api.controllers;

import ch.lukb.bibliothek.api.scheme.Customer;
import ch.lukb.bibliothek.api.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController implements ControllerInterface<Customer> {

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    CustomerService customerService;

    @Override
    @GetMapping("/customers")
    public List<Customer> getAll() {
        return customerService.getAll();
    }

    @Override
    @GetMapping("/customer/{id}")
    public Customer get(Long id) {
        return customerService.get(id);
    }

    @Override
    @PostMapping("/customer")
    public Customer add(Customer customer) {
        return customerService.add(customer);
    }

    @Override
    @DeleteMapping("/customer/{id}")
    public Customer delete(Long id) {
        return customerService.delete(id);
    }

}