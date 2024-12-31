REM   Script: Activity1_2_3_4_5
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

