package com.sametsafkan.mssbrewery.controller;

import com.sametsafkan.mssbrewery.dto.Customer;
import com.sametsafkan.mssbrewery.service.CustomerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable("id") UUID id){
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Customer customer){
        Customer saved = service.save(customer);
        HttpHeaders headers = new HttpHeaders();
        //TODO: add hostname to location
        headers.add("Location", "/mss/v1/customer" + saved.getId().toString());
        return new ResponseEntity(headers, CREATED);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity update(@PathVariable("customerId") UUID customerId, @RequestBody Customer customer){
        service.update(customerId, customer);
        return new ResponseEntity(NO_CONTENT);
    }

    @DeleteMapping("/{customerId}")
    public void delete(@PathVariable("customerId") UUID customerId){
        service.delete(customerId);
    }
}