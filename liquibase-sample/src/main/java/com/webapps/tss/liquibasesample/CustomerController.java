package com.webapps.tss.liquibasesample;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerRepository repository;

    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<Customer>> listAll() {
        List<Customer> all = repository.findAll();
        System.out.println("all = " + all);
        return ResponseEntity.ok().body(all);
    }
}
