SET SERVEROUTPUT ON;


CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    UPDATE accounts
    SET balance = balance * 1.01
    WHERE account_type = 'Savings';
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Success: 1% monthly interest successfully processed for all savings accounts.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error in ProcessMonthlyInterest: ' || SQLERRM);
END;
/