package com.sametsafkan.mssbrewery.service;

import com.sametsafkan.mssbrewery.dto.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto findById(UUID id);

    CustomerDto save(CustomerDto customer);

    void update(UUID customerId, CustomerDto customer);

    void delete(UUID customerId);
}
