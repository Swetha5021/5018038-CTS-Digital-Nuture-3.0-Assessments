DECLARE
    CURSOR c_transactions IS
        SELECT c.CustomerID, c.Name, t.TransactionDate, t.Amount, t.TransactionType
        FROM Customers c
        JOIN Accounts a ON c.CustomerID = a.CustomerID
        JOIN Transactions t ON a.AccountID = t.AccountID
        WHERE t.TransactionDate BETWEEN TRUNC(SYSDATE, 'MM') AND LAST_DAY(SYSDATE);

    v_customer_id Customers.CustomerID%TYPE;
    v_name Customers.Name%TYPE;
    v_transaction_date Transactions.TransactionDate%TYPE;
    v_amount Transactions.Amount%TYPE;
    v_transaction_type Transactions.TransactionType%TYPE;
BEGIN
    OPEN c_transactions;
    LOOP
        FETCH c_transactions INTO v_customer_id, v_name, v_transaction_date, v_amount, v_transaction_type;
        EXIT WHEN c_transactions%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('Customer ID: ' || v_customer_id || ', Name: ' || v_name);
        DBMS_OUTPUT.PUT_LINE('Transaction Date: ' || v_transaction_date || ', Amount: ' || v_amount || ', Type: ' || v_transaction_type);
        DBMS_OUTPUT.PUT_LINE('--------------------------------------------------------');
    END LOOP;
    CLOSE c_transactions;
END;
/
