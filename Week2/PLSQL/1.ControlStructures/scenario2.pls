DECLARE
BEGIN
    -- Enable DBMS_OUTPUT
    DBMS_OUTPUT.ENABLE;

    FOR rec IN (
        SELECT CustomerID, Name, Balance
        FROM Customers
        WHERE Balance > 10000
    ) LOOP
        -- Print before setting VIP status
        DBMS_OUTPUT.PUT_LINE('Before VIP Status - CustomerID: ' || rec.CustomerID || ', Name: ' || rec.Name || ', Balance: ' || rec.Balance || ', IsVIP: FALSE');

        -- Set IsVIP to TRUE
        UPDATE Customers
        SET IsVIP = TRUE
        WHERE CustomerID = rec.CustomerID;

        -- Print after setting VIP status
        DBMS_OUTPUT.PUT_LINE('After VIP Status - CustomerID: ' || rec.CustomerID || ', Name: ' || rec.Name || ', Balance: ' || rec.Balance || ', IsVIP: TRUE');
    END LOOP;

    -- Commit the changes
    COMMIT;
END;
/
