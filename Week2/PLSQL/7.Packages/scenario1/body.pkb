CREATE OR REPLACE PACKAGE BODY CustomerManagement AS
    PROCEDURE AddCustomer (
        p_customer_id NUMBER,
        p_name VARCHAR2,
        p_dob DATE,
        p_balance NUMBER
    ) IS
    BEGIN
        INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
        VALUES (p_customer_id, p_name, p_dob, p_balance, SYSDATE);
    END AddCustomer;

    PROCEDURE UpdateCustomer (
        p_customer_id NUMBER,
        p_name VARCHAR2,
        p_dob DATE,
        p_balance NUMBER
    ) IS
    BEGIN
        UPDATE Customers
        SET Name = p_name,
            DOB = p_dob,
            Balance = p_balance,
            LastModified = SYSDATE
        WHERE CustomerID = p_customer_id;
    END UpdateCustomer;

    FUNCTION GetCustomerBalance (
        p_customer_id NUMBER
    ) RETURN NUMBER IS
        v_balance NUMBER;
    BEGIN
        SELECT Balance INTO v_balance
        FROM Customers
        WHERE CustomerID = p_customer_id;
        RETURN v_balance;
    END GetCustomerBalance;
END CustomerManagement;
/
