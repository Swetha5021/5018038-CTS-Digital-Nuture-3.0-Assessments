DECLARE
    -- Variable to store the age threshold
    age_threshold NUMBER := 60;
BEGIN
    FOR rec IN (
        SELECT c.CustomerID, l.LoanID, l.InterestRate
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID
        WHERE EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM c.DOB) > age_threshold
    ) LOOP
        UPDATE Loans
        SET InterestRate = rec.InterestRate * 0.99
        WHERE LoanID = rec.LoanID;
    END LOOP;
    COMMIT;
END;
/
