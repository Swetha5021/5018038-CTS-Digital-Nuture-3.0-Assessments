package com.swetha.EmployeeManagementSystem.repository.secondary;

import com.swetha.EmployeeManagementSystem.dto.EmployeeDTO;
import com.swetha.EmployeeManagementSystem.model.secondary.Employee;
import com.swetha.EmployeeManagementSystem.projection.EmployeeProjection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	// Fetch specific fields using the projection
    List<EmployeeProjection> findByNameContaining(String namePart);
    
    // Fetch specific fields using a DTO
    @Query("SELECT new com.yourcompanyname.EmployeeManagementSystem.dto.EmployeeDTO(e.id, e.name, e.email) FROM Employee e WHERE e.name LIKE %:namePart%")
    List<EmployeeDTO> findEmployeeDTOsByNameContaining(String namePart);
}