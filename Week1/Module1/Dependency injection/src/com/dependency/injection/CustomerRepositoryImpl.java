package com.dependency.injection;

public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Customer findCustomerById(String id) {
        // In a real application, this would query a database
        // Here we'll just return a dummy customer for demonstration purposes
        return new Customer(id, "John Doe");
    }
}
