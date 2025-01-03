REM   Script: Activity6
REM   This is for FST SQL

CREATE TABLE salesman(salesman_id int PRIMARY KEY, salesman_name varchar2(20), salesman_city varchar(20), commission int);

DESCRIBE salesman


CREATE TABLE salesman(salesman_id int PRIMARY KEY, salesman_name varchar2(20), salesman_city varchar(20), commission int);

DESCRIBE salesman


SELECT * FROM salesman;

INSERT ALL  
    INTO salesman VALUES(5001,'James Hoog', 'New York', 15 ) 
    INTO salesman VALUES(5002,'Nail Knite','Paris', 13) 
    INTO salesman VALUES(5003,'Pit Alex', 'London', 11) 
    INTO salesman VALUES(5005,'McLyon', 'Paris', 14) 
    INTO salesman VALUES(5007,'Priya', 'USA', 15) 
    INTO salesman VALUES(5008,'Karthik', 'Melbourne', 14) 
    SELECT 1 FROM DUAL;

SELECT * FROM salesman;

SELECT salesman_id, salesman_city FROM salesman;

SELECT * FROM  salesman WHERE salesmam_city='Paris';

SELECT * FROM  salesman WHERE salesman_city='Paris';

SELECT salesman_id, commission FROM salesman WHERE salesman_name='Priya';

ALTER TABLE salesman ADD grade int;

SELECT * FROM salesman;

UPDATE salesman SET grade=100;

SELECT * FROM salesman;

UPDATE salesman SET grade=200 WHERE salesman_city='USA';

UPDATE salesman SET grade=200 WHERE salesman_name='James Hoog';

UPDATE salesman SET salesman_name='Pierre' WHERE salesman_name='McLyon';

SELECT * FROM salesman;

SELECT * FROM salesman;

UPDATE salesman SET grade=300 WHERE salesman_name='James Hoog';

SELECT * FROM salesman;

create table orders( 
    order_no int primary key, purchase_amount float, order_date date, 
    customer_id int, salesman_id int);

INSERT ALL 
    INTO orders VALUES(70001, 150.5, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3005, 5002)  
    INTO orders VALUES(70009, 270.65, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3001, 5005) 
    INTO orders VALUES(70002, 65.26, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3002, 5001) 
    INTO orders VALUES(70004, 110.5, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3009, 5003) 
    INTO orders VALUES(70007, 948.5, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3005, 5002) 
    INTO orders VALUES(70005, 2400.6, TO_DATE('2012/07/27', 'YYYY/MM/DD'), 3007, 5001) 
    INTO orders VALUES(70008, 5760, TO_DATE('2012/08/15', 'YYYY/MM/DD'), 3002, 5001) 
    INTO orders VALUES(70010, 1983.43, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3004, 5006) 
    INTO orders VALUES(70003, 2480.4, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3009, 5003) 
    INTO orders VALUES(70012, 250.45, TO_DATE('2012/06/27', 'YYYY/MM/DD'), 3008, 5002) 
    INTO orders VALUES(70011, 75.29, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3003, 5007) 
    INTO orders VALUES(70013, 3045.6, TO_DATE('2012/04/25', 'YYYY/MM/DD'), 3002, 5001) 
SELECT 1 FROM DUAL;

SELECT DISTINCT salesman_id FROM orders;

SELECT order_no, order_date FROM orders ORDER BY order_no ASC;

SELECT order_no, order_date FROM orders ORDER BY order_date;

SELECT order_no, purchase_amount FROM orders ORDER BY purchase_amount DESC;

SELECT * FROM orders WHERE purchase_amount < 500 ORDER BY purchase_amount DESC;

SELECT * FROM orders WHERE purchase_amount BETWEEN 1000 AND 2000 ORDER BY purchase_amount DESC;

