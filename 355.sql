create table deposit (ActNo int, CName varchar (50),BName varchar(50),Amount decimal(8,2),Adate datetime)

--Deposit Table Data Insert
INSERT INTO deposit values(101,'SUNIL','VRCE',10000,'1995-3-1'),
(102,'ANIL','AJNI',5000,'1996-1-4'),
(103,'MEHUL','KAROLBAGH',3500,'1995-11-17'),
(104,'MADHURI','CHANDI',1200,'1995-12-17'),
(105,'PROMOD','M.G.ROAD',3000,'1996-3-27'),
(106,'SANDIP','ANDHERI',2000,'1996-3-31'),
(107,'SHIVANI','VIRAR',1000,'1995-9-5'),
(108,'KARNTI','NEGURU PLAEC',5000,'1995-7-2'),
(109,'MINU','POWAI',7000,'1995-8-10')
select * From deposit



--BRANCH TABLE
create table BRANCH( BName varchar (50),CITY varchar(50))
INSERT INTO BRANCH values('VRCE','NAGPUR')
INSERT INTO BRANCH values('ANIL','NAGPUR')
INSERT INTO BRANCH values('KAROLBAGH','DELHI')
INSERT INTO BRANCH values('CHANDI','DELHI')
INSERT INTO BRANCH values('DHARAMDEEP','NAGPUR')
INSERT INTO BRANCH values('M.G.ROAD','BOBAY')
INSERT INTO BRANCH values('ANDHERI','SURAT')
INSERT INTO BRANCH values('VIRAR','BOBAY')
INSERT INTO BRANCH values('NEGURU PLAEC','BOBAY')
INSERT INTO BRANCH values('POWAI','BOBAY')
select * From BRANCH


create table CUSTUMER ( CName varchar (50),CITY varchar(50))
INSERT INTO CUSTUMER values('ANIL','CALCUTTA')
INSERT INTO CUSTUMER values('SUNIL','DELHI')
INSERT INTO CUSTUMER values('MEHUL','BARODA')
INSERT INTO CUSTUMER values('MANDER','PATNA')
INSERT INTO CUSTUMER values('MADGURI','NAMGPUR')
INSERT INTO CUSTUMER values('PROMOD','NAGPUR')
INSERT INTO CUSTUMER values('SANDIP','SURAT')
INSERT INTO CUSTUMER values('SHIVANI','BOBAY')
INSERT INTO CUSTUMER values('KARNTI','BOBAY')
INSERT INTO CUSTUMER values('MINU','BOBAY')
select * From CUSTUMER

--Retrieve all data from table DEPOSIT.
SELECT * FROM deposit

CREATE TABLE BORROW(LOANNO INT,CNAME VARCHAR(50),BNAME VARCHAR(50), AMOUNT DECIMAL(8,2))
INSERT INTO BORROW VALUES(201,'ANIL','VRCE',1000),
(206,'MEHUL','AJNI',5000),
(311,'SUNIL','DHARAMPETH',3000),
(321,'MADHURI','ANDHERI',2000),
(375,'PRAMOD','VIRAR',8000),
(481,'KRANTI','NEHRU PLACE',3000)

--Retrieve all data from table BORROW.
SELECT * FROM BORROW

--Retrieve all data from table CUSTOMERS
SELECT * FROM CUSTUMER

--Display Account No, Customer Name & Amount from DEPOSIT
SELECT ActNo,CName,Amount FROM DEPOSIT

--Display Loan No, Amount from BORROW
SELECT LOANNO,AMOUNT FROM BORROW

--Display loan details of all customers who belongs to ‘ANDHERI’ branch from borrow table.
SELECT * FROM BORROW WHERE BNAME='ANDHERI'

--Give account no and amount of depositor, whose account no is equals to 106 from deposit table.
SELECT ActNo,Amount FROM DEPOSIT WHERE ActNo=106

--Give name of borrowers having amount greater than 5000 from borrow table
SELECT AMOUNT FROM BORROW WHERE AMOUNT>5000

--Give name of customers who opened account after date '1-12-96' from deposit table
SELECT CName FROM DEPOSIT WHERE Adate > '1996-12-1'

--Display name of customers whose account no is less than 105 from deposit table
SELECT CName FROM DEPOSIT WHERE ActNo < 105

-- Display name of customer who belongs to either ‘NAGPUR’ or ‘DELHI’ from customer table. (OR & IN)
SELECT CName FROM CUSTUMER WHERE CITY='NAGPUR' OR CITY='DELHI'
SELECT CName FROM CUSTUMER WHERE CITY IN('NAGPUR','DELHI')

--Display name of customers with branch whose amount is greater than 4000 and account no is less than 105 from deposit table
SELECT CName FROM DEPOSIT WHERE AMOUNT > 4000 AND ActNo < 105

--Find all borrowers whose amount is greater than equals to 3000 & less than equals to 8000 from borrow table. (AND & BETWEEN)
SELECT * FROM BORROW WHERE AMOUNT >= 3000 AND AMOUNT <= 8000
SELECT * FROM BORROW WHERE AMOUNT BETWEEN 3000 AND 8000

--Find all depositors who do not belongs to ‘ANDHERI’ branch from deposit table.
SELECT * FROM DEPOSIT WHERE BName !='ANDHERI'

--Display Account No, Customer Name & Amount of such customers who belongs to ‘AJNI’, ‘KAROLBAGH’ Or ‘M.G.ROAD’ and Account No is less than 104 from deposit table
SELECT ActNo,CName,Amount FROM DEPOSIT WHERE BName='AJNI' OR BName='KAROLBAGH' OR BName='M.G. ROAD' AND ActNo<104

--PART-B
--Display all the details of first five customers from deposit table.
SELECT TOP 5 CName FROM DEPOSIT 

--Display all the details of first three depositors whose amount is greater than 1000.
SELECT TOP 3 * FROM DEPOSIT WHERE AMOUNT > 1000

--Display Loan No, Customer Name of first five borrowers whose branch name does not belongs to ‘ANDHERI’ from borrow table
SELECT TOP 5 LOANNO,CNAME FROM BORROW WHERE BNAME!='ANDHERI'

--Retrieve all unique cities using DISTINCT. (Use Customers Table)
SELECT DISTINCT CITY FROM CUSTUMER

--Retrieve all unique branches using DISTINCT. (Use Branch Table)
SELECT DISTINCT BName FROM BRANCH