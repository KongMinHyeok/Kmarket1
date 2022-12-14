CREATE DATABASE Kmarket;

CREATE TABLE km_member(
uid VARCHAR(20) NOT NULL PRIMARY KEY, 
pass VARCHAR(255) NOT NULL,
name VARCHAR(20) NOT NULL,
gender TINYINT NOT NULL,
hp CHAR(13) NOT NULL,
email VARCHAR(100) NOT NULL,
type TINYINT NOT NULL,
point INT DEFAULT '0',
level TINYINT DEFAULT '1',
zip VARCHAR(10),
addr1 VARCHAR(255),
addr2 VARCHAR(255),
company VARCHAR(20),
ceo VARCHAR(20),
bizRegNum CHAR(12),
comRegNum VARCHAR(100),
tel VARCHAR(20),
manager VARCHAR(20),
managerHp CHAR(13),
fax VARCHAR(20),
regip VARCHAR(100) NOT NULL,
wdate DATETIME,
rdate DATETIME NOT NULL,
etc1 INT,
etc2 INT,
etc3 VARCHAR(10),
etc4 VARCHAR(20),
etc5 VARCHAR(30),
sessId VARCHAR(20) NOT NULL,
sessDateLimit VARCHAR(20) NOT NULL
);

CREATE TABLE km_member_point(
pointNo INT AUTO_INCREMENT PRIMARY KEY,
uid VARCHAR(20) NOT NULL,
ordNo INT NOT NULL,
point INT NOT NULL,
pointDate DATETIME NOT null
);

CREATE TABLE km_member_terms(
terms TEXT NOT NULL,
privacy TEXT NOT NULL,
location TEXT NOT NULL,
finance TEXT NOT NULL,
tax TEXT NOT null
);