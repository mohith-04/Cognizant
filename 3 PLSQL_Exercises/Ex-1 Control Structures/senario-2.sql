DECLARE
    CURSOR c_high_balance_customers IS
        SELECT customer_id, balance
        FROM customers
        WHERE balance > 10000;
BEGIN
    
    FOR r_cust IN c_high_balance_customers LOOP
    
        UPDATE customers
        SET IsVIP = 'TRUE' 
        WHERE customer_id = r_cust.customer_id;
    END LOOP;
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('VIP status successfully updated for balances over $10,000.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('An error occurred: ' || SQLERRM);
END;
/