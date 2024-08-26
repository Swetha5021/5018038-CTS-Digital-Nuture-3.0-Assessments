package com.swetha.BookStoreAPI.dto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.swetha.BookStoreAPI.model.Customer;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDTO customerToCustomerDTO(Customer customer);
    Customer customerDTOToCustomer(CustomerDTO customerDTO);
}