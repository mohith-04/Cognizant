DECLARE
    --for customers over 60
    CURSOR c_senior_customers IS
        SELECT c.customer_id, l.loan_id, l.interest_rate
        FROM customers c
        JOIN loans l ON c.customer_id = l.customer_id
        WHERE c.age > 60;
BEGIN
    -- loop
    FOR r_cust IN c_senior_customers LOOP
       
        UPDATE loans
        SET interest_rate = interest_rate - 1
        WHERE loan_id = r_cust.loan_id;
    END LOOP;
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('1% interest discount applied successfully to all customers over 60.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('An error occurred: ' || SQLERRM);
END;
/