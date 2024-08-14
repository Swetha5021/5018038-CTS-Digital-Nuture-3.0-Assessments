CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    -- Enable DBMS_OUTPUT
    DBMS_OUTPUT.ENABLE;

    FOR rec IN (
        SELECT AccountID, Balance
        FROM Accounts
        WHERE AccountType = 'Savings'
    ) LOOP
        -- Calculate the new balance with interest
        UPDATE Accounts
        SET Balance = Balance * 1.01,
            LastModified = SYSDATE
        WHERE AccountID = rec.AccountID;

        -- Print the updated balance
        DBMS_OUTPUT.PUT_LINE('Updated AccountID: ' || rec.AccountID || ' New Balance: ' || (rec.Balance * 1.01));
    END LOOP;

    -- Commit the changes
    COMMIT;
END;
/
