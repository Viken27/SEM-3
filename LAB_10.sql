use CSE_3A_106
--LAB-10
--PART-A
CREATE TABLE STUDENT_INFO(
	RNo INT,
	Name VARCHAR(50),
	Branch VARCHAR(25),
	SPI DECIMAL(4,2),
	BkLog int
);
INSERT INTO STUDENT_INFO(RNo,Name,Branch,SPI,BkLog) VALUES
(101,'Raju','CE',8.80,0),
(102,'Amit','CE',2.20,3),
(103,'Sanjay','ME',1.50,6),
(104,'Neha','EC',7.65,1),
(105,'Meera','EE',5.52,2),
(106,'Mahesh','EC',4.50,3);

--1 Create a view Personal with all columns
CREATE VIEW VW_PERSONAL
AS SELECT * FROM STUDENT_INFO

--2 Create a view Student_Details having columns Name, Branch & SPI
CREATE VIEW VW_Student_Details
AS SELECT Name,Branch,SPI FROM STUDENT_INFO;

--3 Create a view AcademicData having columns RNo, Name, Branch.
CREATE VIEW VW_AcademicData
AS SELECT RNo,Name,Branch FROM STUDENT_INFO;

--4 Create a view Student_ bklog having all columns but students whose bklog more than 2
CREATE VIEW VW_Student_bklog
AS SELECT * FROM STUDENT_INFO
WHERE bklog>2;

--5 Create a view Student_Pattern having RNo, Name & Branch columns in which Name consists of four letters.
CREATE VIEW VW_Student_Pattern
AS SELECT RNo,Name,Branch FROM STUDENT_INFO
WHERE Name like '____';

--6 Insert a new record to AcademicData view. (107, Meet, ME)
INSERT INTO VW_AcademicData VALUES (107,'Meet','ME')

--7 Update the branch of Amit from CE to ME in Student_Details view
UPDATE VW_Student_Details
SET BRANCH='ME'
WHERE NAME='Amit'

--8 Delete a student whose roll number is 104 from AcademicData view.
DELETE FROM VW_ACADEMICDATA
WHERE RNo=104;

SELECT * FROM VW_PERSONAL
SELECT * FROM VW_AcademicData
SELECT * FROM VW_Student_bklog
SELECT * FROM VW_Student_Details
SELECT * FROM VW_Student_Pattern

--PART-B

--1 Create a view that displays information of all students whose SPI is above 8.5
CREATE VIEW VW_B1
AS SELECT * FROM STUDENT_INFO
WHERE SPI>8.5

--2 Create a view that displays 0 backlog students.
CREATE VIEW VW_B2
AS SELECT * FROM STUDENT_INFO
WHERE BKLOG=0;

--3 Create a view Computerview that displays CE branch data only.
CREATE VIEW VW_Computerview
AS SELECT * FROM STUDENT_INFO
WHERE BRANCH='CE'

--PART-C

--1 Create a view Result_EC that displays the name and SPI of students with SPI less than 5 of branch EC
CREATE VIEW VW_Result_EC
AS SELECT NAME,SPI FROM STUDENT_INFO
WHERE SPI<5 AND BRANCH='EC'

--2 Update the result of student MAHESH to 4.90 in Result_EC view
UPDATE VW_Result_EC
SET SPI=4.90
WHERE NAME='MAHESH'

--3 Create a view Stu_Bklog with RNo, Name and Bklog columns in which name starts with ‘M’ and having bklogs more than 5.
CREATE VIEW VW_Stu_Bklog
AS SELECT RNo,Name,Bklog FROM STUDENT_INFO
WHERE NAME LIKE 'M%' AND BKLOG>5

--4 Drop Computerview form the database
DROP VIEW VW_COMPUTERVIEW

