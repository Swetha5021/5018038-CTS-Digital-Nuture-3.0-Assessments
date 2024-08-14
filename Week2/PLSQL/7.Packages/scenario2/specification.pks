CREATE OR REPLACE PACKAGE EmployeeManagement AS
    PROCEDURE HireEmployee (
        p_employee_id NUMBER,
        p_name VARCHAR2,
        p_position VARCHAR2,
        p_salary NUMBER,
        p_department VARCHAR2,
        p_hire_date DATE
    );

    PROCEDURE UpdateEmployee (
        p_employee_id NUMBER,
        p_name VARCHAR2,
        p_position VARCHAR2,
        p_salary NUMBER,
        p_department VARCHAR2,
        p_hire_date DATE
    );

    FUNCTION CalculateAnnualSalary (
        p_employee_id NUMBER
    ) RETURN NUMBER;
END EmployeeManagement;
/
