package com.sametsafkan.mssbrewery.mapper;

import com.sametsafkan.mssbrewery.domain.Customer;
import com.sametsafkan.mssbrewery.dto.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
    CustomerDto customerToCustomerDto(Customer customer);
    Customer customerDtoToCustomer(CustomerDto customerDto);
}
