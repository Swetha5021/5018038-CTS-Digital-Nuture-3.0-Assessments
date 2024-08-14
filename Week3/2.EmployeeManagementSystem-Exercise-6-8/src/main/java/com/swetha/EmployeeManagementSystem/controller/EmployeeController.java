package com.swetha.EmployeeManagementSystem.controller;

import com.swetha.EmployeeManagementSystem.model.Employee;
import com.swetha.EmployeeManagementSystem.projection.EmployeeProjection;
import com.swetha.EmployeeManagementSystem.repository.EmployeeRepository;
import com.swetha.EmployeeManagementSystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
    private EmployeeRepository employeeRepository;
	
	// to check projections
    @GetMapping("/employees")
    public List<EmployeeProjection> getEmployeesByName(@RequestParam String namePart) {
        return employeeRepository.findByNameContaining(namePart);
    }

    @Autowired
    private EmployeeService employeeService;

    // Create a new Employee
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // Get an Employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        return employee.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Get all Employees with Pagination and Sorting
    @GetMapping
    public ResponseEntity<Page<Employee>> getAllEmployees(
            @PageableDefault(size = 10, sort = "name") Pageable pageable) {
        Page<Employee> employees = employeeService.getAllEmployees(pageable);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    // Update an Employee
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);

        if (employee.isPresent()) {
            Employee existingEmployee = employee.get();
            existingEmployee.setName(employeeDetails.getName());
            existingEmployee.setEmail(employeeDetails.getEmail());
            existingEmployee.setDepartment(employeeDetails.getDepartment());
            Employee updatedEmployee = employeeService.saveEmployee(existingEmployee);
            return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete an Employee
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}