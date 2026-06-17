CREATE OR REPLACE PROCEDURE TransferFunds (
    p_source_acc IN accounts.account_id%TYPE,
    p_dest_acc   IN accounts.account_id%TYPE,
    p_amount     IN NUMBER
) AS
    v_source_balance accounts.balance%TYPE;
    v_insufficient_funds EXCEPTION;
BEGIN
    SELECT balance INTO v_source_balance
    FROM accounts
    WHERE account_id = p_source_acc;
    IF v_source_balance < p_amount THEN
        RAISE v_insufficient_funds;
    END IF;
    UPDATE accounts
    SET balance = balance - p_amount
    WHERE account_id = p_source_acc;
    
    UPDATE accounts
    SET balance = balance + p_amount
    WHERE account_id = p_dest_acc;
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Success: Transferred $' || p_amount || ' from Account ' || p_source_acc || ' to Account ' || p_dest_acc || '.');

EXCEPTION
    WHEN v_insufficient_funds THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transfer Failed: Source account ' || p_source_acc || ' has insufficient funds.');
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transfer Failed: One or both of the account IDs provided do not exist.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error in TransferFunds: ' || SQLERRM);
END;
/