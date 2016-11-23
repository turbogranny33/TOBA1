DROP DATABASE IF EXISTS toba;

CREATE DATABASE toba;

USE toba;

#DROP TABLE IF EXISTS User;

CREATE TABLE User (
	UserID INT NOT NULL AUTO_INCREMENT,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    Phone VARCHAR(50),
    Address VARCHAR(50),
    City VARCHAR(50),
    State VARCHAR(50),
    ZipCode VARCHAR(50),
    Email VARCHAR(50),
    UserName VARCHAR(50),
    Password VARCHAR(50),

    PRIMARY KEY (UserID)
);

#DROP TABLE IF EXISTS Account;

CREATE TABLE Account (
	AccountID INT NOT NULL AUTO_INCREMENT,
	UserID INT NOT NULL,
    AccountType VARCHAR(50) NOT NULL,
    Balance DECIMAL(7,2) NOT NULL,

    PRIMARY KEY (AccountID),
    FOREIGN KEY (UserID) REFERENCES User (UserID)
);

#DROP TABLE IF EXISTS Transaction;

CREATE TABLE Transaction (
	TransactionID INT NOT NULL AUTO_INCREMENT,
	AccountID INT NOT NULL,
    Amount DECIMAL(7,2) NOT NULL,
    TransactionDate DATETIME NOT NULL,

    PRIMARY KEY (TransactionID),
    FOREIGN KEY (AccountID) REFERENCES Account (AccountID)
);

SELECT * FROM User;
SELECT * FROM Account;
SELECT * FROM Transaction;