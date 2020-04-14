package com.sametsafkan.mssbrewery.service;

import com.sametsafkan.mssbrewery.dto.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto findById(UUID id) {
        return new CustomerDto().builder().id(UUID.randomUUID()).name("Samet Safkan").build();
    }

    @Override
    public CustomerDto save(CustomerDto customer) {
        return new CustomerDto().builder().id(UUID.randomUUID()).name("Samet Safkan").build();
    }

    @Override
    public void update(UUID customerId, CustomerDto customer) {
        //TODO: Implement later
    }

    @Override
    public void delete(UUID customerId) {
        //TODO: Implement later
    }
}
