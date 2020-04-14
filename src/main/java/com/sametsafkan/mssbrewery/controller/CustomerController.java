package com.sametsafkan.mssbrewery.controller;

import com.sametsafkan.mssbrewery.dto.CustomerDto;
import com.sametsafkan.mssbrewery.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService service;

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> findById(@PathVariable("id") UUID id){
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity save(@Valid @RequestBody CustomerDto customer){
        CustomerDto saved = service.save(customer);
        HttpHeaders headers = new HttpHeaders();
        //TODO: add hostname to location
        headers.add("Location", "/mss/v1/customer" + saved.getId().toString());
        return new ResponseEntity(headers, CREATED);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity update(@PathVariable("customerId") UUID customerId, @Valid @RequestBody CustomerDto customer){
        service.update(customerId, customer);
        return new ResponseEntity(NO_CONTENT);
    }

    @DeleteMapping("/{customerId}")
    public void delete(@PathVariable("customerId") UUID customerId){
        service.delete(customerId);
    }
}