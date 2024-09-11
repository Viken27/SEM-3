--LAB-12
CREATE TABLE Dept(
	DepartmentID INT PRIMARY KEY,
	DepartmentName VARCHAR(100) NOT NULL UNIQUE,
	DepartmentCode VARCHAR(50) NOT NULL UNIQUE,
	Location VARCHAR(50) NOT NULL
);
CREATE TABLE Person(
	PersonID INT PRIMARY KEY,
	PersonName VARCHAR(100) NOT NULL,
	DepartmentID INT NULL,
	Salary DECIMAL(8,2) NOT NULL,
	JoiningDate DATETIME NOT NULL,
	City VARCHAR(100) NOT NULL,
	FOREIGN KEY (DepartmentID) REFERENCES Dept(DepartmentID)
);
INSERT INTO Dept(DepartmentID,DepartmentName,DepartmentCode,Location) VALUES
(1,'Admin','Adm','A-Block'),
(2,'Computer','CE','C-Block'),
(3,'Civil','CI','G-Block'),
(4,'Electrical','EE','E-Block'),
(5,'Mechanical','ME','B-Block');
INSERT INTO Person(PersonID,PersonName,DepartmentID,Salary,JoiningDate,City) VALUES
(101,'Rahul Tripathi',2,56000,'2000-01-01','Rajkot'),
(102,'Hardik Pandya',3,18000,'2001-09-25','Ahmedabad'),
(103,'Bhavin Kanani',4,25000,'2000-05-14','Baroda'),
(104,'Bhoomi Vaishnav',1,39000,'2005-02-08','Rajkot'),
(105,'Rohit Topiya',2,17000,'2001-07-23','Jamnagar'),
(106,'Priya Menpara',NULL,9000,'2000-10-18','Ahmedabad'),
(107,'Neha Sharma',2,34000,'2002-12-25','Rajkot'),
(108,'Nayan Goswami',3,25000,'2001-07-01','Rajkot'),
(109,'Mehul Bhundiya',4,13500,'2005-01-09','Baroda'),
(110,'Mohit Maru',5,14000,'2000-05-25','Jamnagar');

--PART-A
--1 Find all persons with their department name & code
SELECT p.PersonName,d.DepartmentName,d.DepartmentCode FROM PERSON AS p LEFT JOIN DEPT AS d ON p.DepartmentID=d.DepartmentID

--2 Find the person's name whose department is in C-Block.
SELECT p.PersonName FROM PERSON AS p INNER JOIN DEPT AS d ON p.DepartmentID=d.DepartmentID WHERE d.Location='C-Block';

--3 Retrieve person name, salary & department name who belongs to Jamnagar city.
SELECT p.PersonName,p.Salary,d.DepartmentName FROM PERSON AS p LEFT JOIN DEPT AS d ON p.DepartmentID=d.DepartmentID WHERE p.City='Jamnagar';

--4 Retrieve person name, salary & department name who does not belong to Rajkot city.
SELECT P.PersonName,P.Salary,d.DepartmentName FROM PERSON AS P LEFT JOIN DEPT AS D ON P.DepartmentID=D.DepartmentID WHERE P.City !='Rajkot'

--5 Retrieve person’s name of the person who joined the Civil department after 1-Aug-2001.
SELECT P.PersonName FROM PERSON AS P INNER JOIN DEPT AS D ON P.DepartmentID=D.DepartmentID WHERE D.DepartmentName='Civil' AND P.JoiningDate>'2001-08-01'

--6 Find details of all persons who belong to the computer department
SELECT * FROM PERSON AS P INNER JOIN DEPT AS D ON P.DepartmentID=D.DepartmentID WHERE D.DepartmentName='Computer';

--7 Display all the person's name with the department whose joining date difference with the current date is more than 365 days
SELECT P.PersonName,d.DepartmentName FROM PERSON AS P LEFT JOIN DEPT AS D ON P.DepartmentID=D.DepartmentID WHERE DATEDIFF(DAY,P.JoiningDate,GETDATE())>365

--8 Find department wise person counts
SELECT D.DepartmentName,COUNT(P.PersonID) FROM PERSON AS P INNER JOIN DEPT AS D ON P.DepartmentID=D.DepartmentID GROUP BY D.DepartmentName;

--9 Give department wise maximum & minimum salary with department name.
SELECT D.DepartmentName,MAX(P.SALARY) AS MAX_SAL,MIN(P.SALARY) AS MIN_SAL FROM PERSON AS P INNER JOIN DEPT AS D ON P.DepartmentID=D.DepartmentID GROUP BY D.DepartmentName;

--10 Find city wise total, average, maximum and minimum salary.
SELECT P.CITY,SUM(P.SALARY) AS TOTAL_SAL,AVG(P.SALARY) AS AVG_SAL,MAX(P.SALARY) AS MAX_SAL,MIN(P.SALARY) AS MIN_SAL FROM PERSON AS P LEFT JOIN DEPT AS D ON P.DepartmentID=D.DepartmentID GROUP BY P.CITY;

--11 Find the average salary of a person who belongs to Ahmedabad city.
SELECT AVG(P.SALARY) FROM PERSON AS P LEFT JOIN DEPT AS D ON P.DepartmentID=D.DepartmentID WHERE P.CITY='Ahmedabad'

--12 Produce Output Like: <PersonName> lives in <City> and works in <DepartmentName> Department. (In single column)
SELECT P.PersonName+' lives in '+P.City+' and works in '+D.DepartmentName FROM PERSON AS P INNER JOIN DEPT AS D ON P.DepartmentID=D.DepartmentID

--PART-B
--1 Produce Output Like: <PersonName> earns <Salary> from <DepartmentName> department monthly. (In single column)
SELECT P.PersonName+' earns '+CAST(P.Salary AS VARCHAR)+' from '+D.departmentName+' department monthly' FROM PERSON AS P JOIN DEPT AS D ON P.DepartmentID=D.DepartmentID

--2 Find city & department wise total, average & maximum salaries.
SELECT P.City,D.DepartmentName,SUM(P.SALARY),AVG(P.SALARY),MAX(P.SALARY) FROM PERSON AS P INNER JOIN DEPT AS D ON P.DepartmentID=D.DepartmentID GROUP BY P.City,D.DepartmentName;

--3  Find all persons who do not belong to any department.
SELECT P.PersonName FROM PERSON AS P LEFT JOIN DEPT AS D ON P.DepartmentID=D.DepartmentID WHERE D.DepartmentID IS NULL;

--4 Find all departments whose total salary is exceeding 100000.
SELECT D.DepartmentName,SUM(P.SALARY) FROM PERSON AS P INNER JOIN DEPT AS D ON P.DepartmentID=D.DepartmentID GROUP BY D.DepartmentName HAVING SUM(P.SALARY)>100000

--PART-C
--1 List all departments who have no person
SELECT D.DepartmentName,COUNT(P.PersonName) FROM PERSON AS P JOIN DEPT AS D ON P.DepartmentID=D.DepartmentID GROUP BY D.DepartmentName HAVING COUNT(P.PersonName)=0;

--2 List out department names in which more than two persons are working.
SELECT D.DepartmentName,COUNT(P.PersonName) FROM PERSON AS P JOIN DEPT AS D ON P.DepartmentID=D.DepartmentID GROUP BY D.DepartmentName HAVING COUNT(P.PersonName)>2

--3 Give a 10% increment in the computer department employee’s salary. (Use Update)
Update P
SET P.SALARY=1.1*P.SALARY
FROM PERSON AS P INNER JOIN DEPT AS D
ON P.DepartmentID=D.DepartmentID
WHERE D.DepartmentName='Computer'