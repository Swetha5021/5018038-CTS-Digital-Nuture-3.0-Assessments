CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
    v_balance NUMBER;
BEGIN
    -- Get the current balance of the account
    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = :NEW.AccountID
    FOR UPDATE;

    -- Check if the transaction is a withdrawal
    IF :NEW.TransactionType = 'Withdrawal' THEN
        -- Ensure the withdrawal does not exceed the balance
        IF :NEW.Amount > v_balance THEN
            RAISE_APPLICATION_ERROR(-20001, 'Error: Insufficient balance for withdrawal.');
        END IF;
    ELSIF :NEW.TransactionType = 'Deposit' THEN
        -- Ensure the deposit amount is positive
        IF :NEW.Amount <= 0 THEN
            RAISE_APPLICATION_ERROR(-20002, 'Error: Deposit amount must be positive.');
        END IF;
    END IF;
END;
/
