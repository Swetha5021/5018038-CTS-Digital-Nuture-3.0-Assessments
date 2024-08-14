package com.swetha.EmployeeManagementSystem.service;

import com.swetha.EmployeeManagementSystem.model.Employee;
import com.swetha.EmployeeManagementSystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Create or Update an Employee
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Read: Find Employee by ID
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    // Read: Find All Employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Delete an Employee
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}