BEGIN
    -- Enable DBMS_OUTPUT
    DBMS_OUTPUT.ENABLE;

    FOR rec IN (
        SELECT c.CustomerID, c.Name, l.LoanID, l.EndDate
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        -- Print reminder message
        DBMS_OUTPUT.PUT_LINE('Reminder: Customer ' || rec.Name || ' (CustomerID: ' || rec.CustomerID || '), your loan (LoanID: ' || rec.LoanID || ') is due on ' || TO_CHAR(rec.EndDate, 'DD-MON-YYYY') || '.');
    END LOOP;
END;
/
