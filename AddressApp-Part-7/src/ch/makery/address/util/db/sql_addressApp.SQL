/*
Created: 29/09/2019
Modified: 29/09/2019
Model: MySQL 5.7
Database: MySQL 5.7
*/


-- Create tables section -------------------------------------------------

-- Table Person

CREATE DATABASE addressapp;

USE addressapp;

CREATE TABLE `Person`
(
  `FirstName` Varchar(50) NOT NULL,
  `LastName` Varchar(100) NOT NULL,
  `Street` Varchar(250) NOT NULL,
  `PostalCode` Int NOT NULL,
  `City` Varchar(100) NOT NULL,
  `Birthday` Date NOT NULL
)
;

ALTER TABLE `Person` ADD PRIMARY KEY (`FirstName`,`LastName`)
;


