CREATE OR REPLACE FUNCTION HasSufficientBalance (
    p_account_id NUMBER,
    p_amount NUMBER
) RETURN BOOLEAN IS
    v_balance NUMBER;
BEGIN
    -- Get the current balance of the account
    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = p_account_id;

    -- Check if the balance is sufficient
    IF v_balance >= p_amount THEN
        RETURN TRUE;
    ELSE
        RETURN FALSE;
    END IF;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN FALSE;
    WHEN OTHERS THEN
        RETURN FALSE;
END;
/
