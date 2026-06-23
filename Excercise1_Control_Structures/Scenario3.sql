SET SERVEROUTPUT ON;

BEGIN
    FOR l IN (
        SELECT LoanID,CustomerID,EndDate
        FROM Loans
        WHERE EndDate BETWEEN SYSDATE AND SYSDATE+30
    ) LOOP

        DBMS_OUTPUT.PUT_LINE(
        'Reminder for Customer '
        ||l.CustomerID||
        ' Loan ID '
        ||l.LoanID);

    END LOOP;
END;
/