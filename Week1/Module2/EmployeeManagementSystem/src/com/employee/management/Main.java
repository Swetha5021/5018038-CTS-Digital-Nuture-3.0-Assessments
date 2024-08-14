package com.employee.management;

public class Main {
    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem(10);

        // Adding employees
        ems.addEmployee(new Employee("E001", "Alice", "Manager", 75000));
        ems.addEmployee(new Employee("E002", "Bob", "Developer", 60000));
        ems.addEmployee(new Employee("E003", "Charlie", "Designer", 55000));

        // Traverse employees
        System.out.println("Employee list:");
        ems.traverseEmployees();

        // Search for an employee
        Employee emp = ems.searchEmployee("E002");
        if (emp != null) {
            System.out.println("\nFound employee: " + emp.getName() + ", " + emp.getPosition() + ", $" + emp.getSalary());
        } else {
            System.out.println("\nEmployee not found.");
        }

        // Delete an employee
        ems.deleteEmployee("E002");

        // Traverse employees after deletion
        System.out.println("\nEmployee list after deletion:");
        ems.traverseEmployees();
    }
}
