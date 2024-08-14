package com.swetha.EmployeeManagementSystem.repository;

import com.swetha.EmployeeManagementSystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Derived query method to find employees by name
    List<Employee> findByName(String name);

    // Derived query method to find employees by email
    Employee findByEmail(String email);

    // Derived query method to find employees by department id
    List<Employee> findByDepartmentId(Long departmentId);
    
    //excercise 5
    //1.Using Keywords in Method names
    // Find employees by name containing a certain string
    List<Employee> findByNameContaining(String namePart);

    // Find employees whose email ends with a specific domain
    List<Employee> findByEmailEndingWith(String domain);

    // Find employees by department name
    List<Employee> findByDepartmentName(String departmentName);
    
    //2. Using the @Query Annotation
    // Custom query to find employees by department name using @Query
    @Query("SELECT e FROM Employee e WHERE e.department.name = :departmentName")
    List<Employee> findEmployeesByDepartmentName(@Param("departmentName") String departmentName);

    // Custom query to find employees with a specific email domain using native SQL
    @Query(value = "SELECT * FROM Employee e WHERE e.email LIKE %:domain", nativeQuery = true)
    List<Employee> findEmployeesByEmailDomain(@Param("domain") String domain);
    
    //named query
 // Using the named query defined in Employee entity
    List<Employee> findByDepartmentNameNamedQuery(@Param("departmentName") String departmentName);

    // Another named query to find employees by name
    List<Employee> findByNameNamedQuery(@Param("name") String name);
}