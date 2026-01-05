CREATE DATABASE MultiUserBankingEngine;
USE MultiUserBankingEngine;

CREATE TABLE users(
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(100),
cnic VARCHAR(15) UNIQUE,
age INT,
account_type VARCHAR(15),
balance DOUBLE
);

SELECT * FROM users;