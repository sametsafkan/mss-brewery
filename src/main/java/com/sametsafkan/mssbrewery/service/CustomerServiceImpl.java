package com.sametsafkan.mssbrewery.service;

import com.sametsafkan.mssbrewery.dto.Customer;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public Customer findById(UUID id) {
        return new Customer().builder().id(UUID.randomUUID()).name("Samet Safkan").build();
    }

    @Override
    public Customer save(Customer customer) {
        return new Customer().builder().id(UUID.randomUUID()).name("Samet Safkan").build();
    }

    @Override
    public void update(UUID customerId, Customer customer) {
        //TODO: Implement later
    }

    @Override
    public void delete(UUID customerId) {
        //TODO: Implement later
    }
}
