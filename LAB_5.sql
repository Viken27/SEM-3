use CSE_3A_106
--PART-A
CREATE TABLE STUDENT(
	StuID INT,
	FirstName VARCHAR(25),
	LastName VARCHAR(25),
	Website VARCHAR(50),
	City VARCHAR(25),
	Address	VARCHAR(100)
);
INSERT INTO STUDENT(StuID,FirstName,LastName,Website,City,Address) VALUES(1011,'Keyur','Patel','techonthenet.com','Rajkot','A-303 ''Vasant Kunj'', Rajkot'),
(1022,'Hardik','Shah','digminecraft.com','Ahmedabad','"Ram Krupa", Raiya Road'),
(1033,'Kajal','Trivedi','bigactivities.com','Baroda','Raj Bhavan plot, near garden'),
(1044,'Bhoomi','Gajera','checkyourmath.com','Ahmedabad','Jig''s Home, Narol'),
(1055,'Harmit','Mitel','@me.darshan.com','Rajkot','B-55, Raj Residency'),
(1066,'Ashok','Jani',NULL,'Baroda','A502, Club House Building')
--1 Display the name of students whose name starts with �k�.
SELECT FIRSTNAME FROM STUDENT
WHERE FIRSTNAME LIKE 'K%';

--2 Display the name of students whose name consists of five characters
SELECT FIRSTNAME FROM STUDENT
WHERE FIRSTNAME LIKE '_____';

--3 Retrieve the first name & last name of students whose city name ends with a & contains six characters.