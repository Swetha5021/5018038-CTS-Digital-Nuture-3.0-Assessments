DECLARE
    CURSOR c_accounts IS
        SELECT AccountID, Balance
        FROM Accounts;

    v_account_id Accounts.AccountID%TYPE;
    v_balance Accounts.Balance%TYPE;
    v_annual_fee CONSTANT NUMBER := 50;
BEGIN
    OPEN c_accounts;
    LOOP
        FETCH c_accounts INTO v_account_id, v_balance;
        EXIT WHEN c_accounts%NOTFOUND;

        -- Deduct annual fee
        UPDATE Accounts
        SET Balance = Balance - v_annual_fee,
            LastModified = SYSDATE
        WHERE AccountID = v_account_id;

        DBMS_OUTPUT.PUT_LINE('Account ID: ' || v_account_id || ' New Balance: ' || (v_balance - v_annual_fee));
    END LOOP;
    CLOSE c_accounts;

    -- Commit the changes
    COMMIT;
END;
/
