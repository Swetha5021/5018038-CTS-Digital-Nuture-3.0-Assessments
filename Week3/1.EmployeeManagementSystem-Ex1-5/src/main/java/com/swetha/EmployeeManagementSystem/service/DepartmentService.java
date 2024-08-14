package com.swetha.EmployeeManagementSystem.service;

import com.swetha.EmployeeManagementSystem.model.Department;
import com.swetha.EmployeeManagementSystem.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    // Create or Update a Department
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    // Read: Find Department by ID
    public Optional<Department> getDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }

    // Read: Find All Departments
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    // Delete a Department
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}