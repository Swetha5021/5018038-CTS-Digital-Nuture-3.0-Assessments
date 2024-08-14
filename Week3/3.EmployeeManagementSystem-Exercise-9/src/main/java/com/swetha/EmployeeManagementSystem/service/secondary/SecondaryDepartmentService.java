package com.swetha.EmployeeManagementSystem.service.secondary;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swetha.EmployeeManagementSystem.model.secondary.Department;
import com.swetha.EmployeeManagementSystem.repository.secondary.DepartmentRepository;

@Service
public class SecondaryDepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    // Get all departments
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    // Get department by ID
    public Optional<Department> getDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }

    // Create a new department
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    // Update an existing department
    public Optional<Department> updateDepartment(Long id, Department departmentDetails) {
        return departmentRepository.findById(id).map(department -> {
            department.setName(departmentDetails.getName());
            return departmentRepository.save(department);
        });
    }

    // Delete a department
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}