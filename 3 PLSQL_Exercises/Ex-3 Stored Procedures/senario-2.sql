CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department_id    IN employees.department_id%TYPE,
    p_bonus_percentage IN NUMBER
) AS
BEGIN
    UPDATE employees
    SET salary = salary * (1 + (p_bonus_percentage / 100))
    WHERE department_id = p_department_id;
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Success: Bonus of ' || p_bonus_percentage || '% applied to department ' || p_department_id || '.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error in UpdateEmployeeBonus: ' || SQLERRM);
END;
/