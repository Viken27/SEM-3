USE CSE_3A_106
--LAB-7
--PART-A
CREATE TABLE EMP(
	EID INT,
	ENAME VARCHAR(50),
	Department varchar(50),
	Salary INT,
	JoiningDate DATETIME,
	City VARCHAR(50)
);
INSERT INTO EMP(EID,ENAME,DEPARTMENT,SALARY,JOININGDATE,CITY) VALUES (101,'Rahul','Admin',56000,'1990-01-01','Rajkot'),
(102,'Hardik','IT',18000,'1990-09-25','Ahmedabad'),
(103,'Bhavin','HR',25000,'1991-05-14','Baroda'),
(104,'Bhoomi','Admin',39000,'1991-02-08','Rajkot'),
(105,'Rohit','IT',17000,'1990-07-23','Jamnagar'),
(106,'Priya','IT',9000,'1990-10-18','Ahmedabad'),
(107,'Bhoomi','HR',34000,'1991-12-25','Rajkot');

--1 Display the Highest, Lowest, Label the columns Maximum, Minimum respectively
SELECT MAX(SALARY) AS MAXIMUM,MIN(SALARY) AS MINIMUM FROM EMP 

--2 Display Total, and Average salary of all employees. Label the columns Total_Sal and Average_Sal,respectively.
SELECT SUM(SALARY) AS TOTAL_SAL,AVG(SALARY) AS AVERAGE_SAL FROM EMP

--3 Find total number of employees of EMPLOYEE table
SELECT COUNT(*) FROM EMP;

--4 Find highest salary from Rajkot city.
SELECT MAX(SALARY) FROM EMP
WHERE CITY = 'RAJKOT';

--5 Give maximum salary from IT department
SELECT MAX(SALARY) FROM EMP
WHERE Department = 'IT';

--6 Count employee whose joining date is after 8-feb-91.
SELECT COUNT(*) FROM EMP
WHERE JoiningDate>'1991-02-08';

--7 Display average salary of Admin department.
SELECT AVG(SALARY) FROM EMP
WHERE Department='ADMIN';

--8 Display total salary of HR department.
SELECT SUM(SALARY) FROM EMP
WHERE Department='HR';

--9 Count total number of cities of employee without duplication.
SELECT COUNT(DISTINCT CITY) FROM EMP

--10 Count unique departments.
SELECT COUNT(DISTINCT DEPARTMENT) FROM EMP;

--11 Give minimum salary of employee who belongs to Ahmedabad.
SELECT MIN(SALARY) FROM EMP
WHERE CITY='AHMEDABAD';

--12 Find city wise highest salary