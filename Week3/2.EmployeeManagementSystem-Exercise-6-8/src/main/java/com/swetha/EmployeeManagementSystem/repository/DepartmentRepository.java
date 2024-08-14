package com.swetha.EmployeeManagementSystem.repository;

import com.swetha.EmployeeManagementSystem.dto.DepartmentDTO;
import com.swetha.EmployeeManagementSystem.model.Department;
import com.swetha.EmployeeManagementSystem.projection.DepartmentProjection;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    
	// Fetch specific fields using the projection
    List<DepartmentProjection> findByNameContaining(String namePart);
    
    // Fetch specific fields using a DTO
    @Query("SELECT new com.yourcompanyname.EmployeeManagementSystem.dto.DepartmentDTO(d.id, d.name) FROM Department d WHERE d.name LIKE %:namePart%")
    List<DepartmentDTO> findDepartmentDTOsByNameContaining(String namePart);
}