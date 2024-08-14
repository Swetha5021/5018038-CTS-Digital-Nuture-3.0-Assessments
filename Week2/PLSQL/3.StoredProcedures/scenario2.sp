CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department IN VARCHAR2,
    p_bonus_percentage IN NUMBER
) IS
BEGIN
    -- Enable DBMS_OUTPUT
    DBMS_OUTPUT.ENABLE;

    FOR rec IN (
        SELECT EmployeeID, Salary
        FROM Employees
        WHERE Department = p_department
    ) LOOP
        -- Update the salary with the bonus percentage
        UPDATE Employees
        SET Salary = Salary * (1 + p_bonus_percentage / 100)
        WHERE EmployeeID = rec.EmployeeID;

        -- Print the updated salary
        DBMS_OUTPUT.PUT_LINE('Updated EmployeeID: ' || rec.EmployeeID || ' New Salary: ' || (rec.Salary * (1 + p_bonus_percentage / 100)));
    END LOOP;

    -- Commit the changes
    COMMIT;
END;
/
