package com.swetha.BookStoreAPI.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.swetha.BookStoreAPI.dto.CustomerDTO;
import com.swetha.BookStoreAPI.dto.CustomerMapper;
import com.swetha.BookStoreAPI.model.Customer;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private List<Customer> customerList = new ArrayList<>();
    
    // Create a new customer
    @PostMapping
    public ResponseEntity<CustomerDTO> addCustomer(@RequestBody CustomerDTO customerDTO) {
        Customer customer = CustomerMapper.INSTANCE.customerDTOToCustomer(customerDTO);
        customerList.add(customer);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "Customer-Creation");
        return new ResponseEntity<>(customerDTO, headers, HttpStatus.CREATED);
    }
    
    // Get a single customer by ID
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable int id) {
        Customer customer = customerList.stream().filter(c -> c.getId() == id)
                .findFirst().orElseThrow(() -> new RuntimeException("Customer not found"));
        CustomerDTO customerDTO = CustomerMapper.INSTANCE.customerToCustomerDTO(customer);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "Customer-Details");
        return new ResponseEntity<>(customerDTO, headers, HttpStatus.OK);
    }
    
    // Get all customers
    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        List<CustomerDTO> customerDTOs = new ArrayList<>();
        for (Customer customer : customerList) {
            customerDTOs.add(CustomerMapper.INSTANCE.customerToCustomerDTO(customer));
        }
        return new ResponseEntity<>(customerDTOs, HttpStatus.OK);
    }

    // Update an existing customer
    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable int id, @RequestBody CustomerDTO customerDTO) {
        Customer customer = customerList.stream().filter(c -> c.getId() == id)
                .findFirst().orElseThrow(() -> new RuntimeException("Customer not found"));
        
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        customer.setAddress(customerDTO.getAddress());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "Customer-Update");
        return new ResponseEntity<>(CustomerMapper.INSTANCE.customerToCustomerDTO(customer), headers, HttpStatus.OK);
    }

    // Delete a customer by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable int id) {
        boolean removed = customerList.removeIf(customer -> customer.getId() == id);
        if (!removed) {
            throw new RuntimeException("Customer not found");
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "Customer-Deletion");
        return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
    }
}