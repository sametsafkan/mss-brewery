package com.sametsafkan.mssbrewery.service;

import com.sametsafkan.mssbrewery.dto.Customer;

import java.util.UUID;

public interface CustomerService {
    Customer findById(UUID id);

    Customer save(Customer customer);

    void update(UUID customerId, Customer customer);

    void delete(UUID customerId);
}
