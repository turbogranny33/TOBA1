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
    Password VARCHAR(64),
    Salt VARCHAR(50),
    RegistrationDate DATETIME NOT NULL,

    PRIMARY KEY (UserID)
);

#DROP TABLE IF EXISTS AdminUser;

CREATE TABLE AdminUser (
    UserName VARCHAR(50) NOT NULL,
    Password VARCHAR(64),

    PRIMARY KEY (UserName)
);


#DROP TABLE IF EXISTS UserRole;

CREATE TABLE UserRole (
    UserName VARCHAR(50) NOT NULL,
    RoleName VARCHAR(50) NOT NULL,

    PRIMARY KEY (UserName, RoleName)
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
	SourceAccountID INT NOT NULL,
    DestinationAccountID INT NOT NULL,
    Amount DECIMAL(7,2) NOT NULL,
    TransactionDate DATETIME NOT NULL,

    PRIMARY KEY (TransactionID),
    FOREIGN KEY (SourceAccountID) REFERENCES Account (AccountID),
    FOREIGN KEY (DestinationAccountID) REFERENCES Account (AccountID)
);

INSERT INTO AdminUser (UserName, Password) VALUES
('admin', 'sesame');

INSERT INTO UserRole (UserName, RoleName) VALUES
('admin', 'admin');

SELECT * FROM User;
SELECT * FROM AdminUser;
SELECT * FROM UserRole;
SELECT * FROM Account;
SELECT * FROM Transaction;