package com.swetha.EmployeeManagementSystem.repository;

import com.swetha.EmployeeManagementSystem.model.Department;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // Derived query method to find departments by name
    Department findByName(String name);
    
    //excercise 5
    //1.Using Keywords in Method names
    // Find departments by name containing a certain string
    List<Department> findByNameContaining(String namePart);
}