DECLARE
 
    CURSOR c_due_loans IS
        SELECT c.first_name, c.last_name, l.due_date, l.loan_amount
        FROM customers c
        JOIN loans l ON c.customer_id = l.customer_id
        WHERE l.due_date BETWEEN SYSDATE AND (SYSDATE + 30);
BEGIN
    
    
    FOR r_loan IN c_due_loans LOOP
        
        DBMS_OUTPUT.PUT_LINE(
            'REMINDER: Dear ' || r_loan.first_name || ' ' || r_loan.last_name || 
            ', your loan payment of $' || r_loan.loan_amount || 
            ' is due on ' || TO_CHAR(r_loan.due_date, 'YYYY-MM-DD') || '.'
        );
    END LOOP;
END;
/