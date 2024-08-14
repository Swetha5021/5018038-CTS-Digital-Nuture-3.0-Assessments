package com.dependency.injection;

public interface CustomerRepository {
    Customer findCustomerById(String id);
}
