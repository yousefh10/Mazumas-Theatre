-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 05, 2022 at 05:31 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.1.12

DROP USER '480'@'localhost';

CREATE USER '480'@'localhost' IDENTIFIED BY '123456789';

DROP DATABASE IF EXISTS MOVIETHEATRE_DB;

CREATE DATABASE MOVIETHEATRE_DB;

USE MOVIETHEATRE_DB;

GRANT ALL PRIVILEGES ON * . * TO '480'@'localhost';

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;

/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;

/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;

/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `movietheatre_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `ACCOUNT` (
  `FIRSTNAME` VARCHAR(50) NOT NULL,
  `LASTNAME` VARCHAR(50) NOT NULL,
  `USERNAME` VARCHAR(50) NOT NULL,
  `PASSWORD` VARCHAR(50) NOT NULL,
  `EMAIL` VARCHAR(50) NOT NULL,
  `CARDNUMBER` BIGINT(50) NOT NULL,
  `CVV` INT(3) NOT NULL,
  `BILLING` VARCHAR(50) NOT NULL,
  `EXPIRATION` VARCHAR(50) NOT NULL
) ENGINE=INNODB DEFAULT CHARSET=UTF8MB4 COLLATE=UTF8MB4_GENERAL_CI;

--
-- Dumping data for table `account`
--

INSERT INTO `ACCOUNT` (
  `FIRSTNAME`,
  `LASTNAME`,
  `USERNAME`,
  `PASSWORD`,
  `EMAIL`,
  `CARDNUMBER`,
  `CVV`,
  `BILLING`,
  `EXPIRATION`
) VALUES (
  'Hamza',
  'Niaz',
  'hamzaniaz',
  'niazullah',
  'hamzaniaz.pk@gmail.com',
  1,
  112,
  'i',
  '12/12'
),
(
  'Issam',
  'Akhtar',
  'admin',
  'issam',
  'issam.akhtar@ucalgary.ca',
  1,
  123,
  'i',
  '02/22'
),
(
  'Issam',
  'Akhtar',
  'i',
  'i',
  'issam.akhtar@gmail.com',
  1,
  123,
  'i',
  '02/22'
),
(
  'Yousef',
  'Akhtar',
  'y',
  'i',
  'yousefhammad10@gmail.com',
  1,
  123,
  'i',
  '02/22'
);

-- --------------------------------------------------------

--
-- Table structure for table `guest`
--

CREATE TABLE `GUEST` (
  `FIRSTNAME` VARCHAR(50) NOT NULL,
  `LASTNAME` VARCHAR(50) NOT NULL,
  `EMAIL` VARCHAR(50) NOT NULL,
  `CARDNUMBER` BIGINT(50) NOT NULL,
  `CVV` INT(3) NOT NULL,
  `EXPIRATION` VARCHAR(50) NOT NULL,
  `BILLING` VARCHAR(50) NOT NULL
) ENGINE=INNODB DEFAULT CHARSET=UTF8 COLLATE=UTF8_GENERAL_CI;

-- --------------------------------------------------------

--
-- Table structure for table `movie`
--

CREATE TABLE `MOVIE` (
  `NAME` VARCHAR(50) NOT NULL,
  `SCREENTIME` VARCHAR(50) NOT NULL
) ENGINE=INNODB DEFAULT CHARSET=UTF8MB4 COLLATE=UTF8MB4_GENERAL_CI;

--
-- Dumping data for table `movie`
--
INSERT INTO `MOVIE` (
  `NAME`,
  `SCREENTIME`
) VALUES (
  'Rush Hour',
  '9:30 2022-12-20'
),
(
  'Rush Hour',
  '11:30 2022-12-22'
),
(
  'Rush Hour',
  '13:30 2022-12-23'
),
(
  'Rush Hour',
  '15:30 2022-12-26'
),
(
  'Rush Hour',
  '17:30 2022-12-29'
),
(
  'Lord of the Rings',
  '9:45 2022-12-21'
),
(
  'Lord of the Rings',
  '11:45 2022-12-23'
),
(
  'Lord of the Rings',
  '13:45 2022-12-24'
),
(
  'Lord of the Rings',
  '15:45 2022-12-25'
),
(
  'Lord of the Rings',
  '17:45 2022-12-27'
),
(
  'Parasite',
  '11:00 2022-12-20'
),
(
  'Parasite',
  '13:00 2022-12-22'
),
(
  'Parasite',
  '15:00 2022-12-23'
),
(
  'Parasite',
  '9:00 2022-12-24'
),
(
  'Parasite',
  '17:00 2022-12-25'
),
(
  'The Prestige',
  '10:30 2022-12-19'
),
(
  'The Prestige',
  '12:30 2022-12-21'
),
(
  'The Prestige',
  '14:30 2022-12-22'
),
(
  'The Prestige',
  '16:30 2022-12-24'
),
(
  'The Prestige',
  '18:30 2022-12-25'
),
(
  'The Revenant',
  '10:45 2022-12-20'
),
(
  'The Revenant',
  '12:45 2022-12-22'
),
(
  'The Revenant',
  '14:45 2022-12-23'
),
(
  'The Revenant',
  '16:45 2022-12-25'
),
(
  'The Revenant',
  '18:45 2022-12-27'
),
(
  'Seven',
  '10:00 2022-12-21'
),
(
  'Seven',
  '12:00 2022-12-23'
),
(
  'Seven',
  '14:00 2022-12-25'
),
(
  'Seven',
  '16:00 2022-12-27'
),
(
  'Seven',
  '18:00 2022-12-29'
);

-- --------------------------------------------------------

--
-- Table structure for table `seat`
--

CREATE TABLE `SEAT` (
  `SEATNUMBER` INT(50) NOT NULL,
  `AVAILABILITY` TINYINT(1) NOT NULL,
  `MOVIENAME` VARCHAR(50) NOT NULL,
  `SHOWTIME` VARCHAR(50) NOT NULL
) ENGINE=INNODB DEFAULT CHARSET=UTF8MB4 COLLATE=UTF8MB4_GENERAL_CI;

-- --------------------------------------------------------

--
-- Table structure for table `showtime`
--

CREATE TABLE `SHOWTIME` (
  `MOVIENAME` VARCHAR(50) NOT NULL,
  `SHOWDATE` DATETIME NOT NULL
) ENGINE=INNODB DEFAULT CHARSET=UTF8MB4 COLLATE=UTF8MB4_GENERAL_CI;

-- --------------------------------------------------------

--
-- Table structure for table `ticket`
--

CREATE TABLE `TICKET` (
  `TICKETNUMBER` INT(11) NOT NULL,
  `SEATNUMBER` VARCHAR(50) NOT NULL,
  `MOVIENAME` VARCHAR(50) NOT NULL,
  `PRICE` FLOAT NOT NULL,
  `SHOWTIME` VARCHAR(50) NOT NULL
) ENGINE=INNODB DEFAULT CHARSET=UTF8MB4 COLLATE=UTF8MB4_GENERAL_CI;

--
-- Dumping data for table `ticket`
--



--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `ACCOUNT` ADD PRIMARY KEY (`EMAIL`);

--
-- Indexes for table `guest`
--
ALTER TABLE `GUEST` ADD PRIMARY KEY (`EMAIL`);

--
-- Indexes for table `movie`
--

--
-- Indexes for table `seat`
--
ALTER TABLE `SEAT` ADD PRIMARY KEY (`SEATNUMBER`);

--
-- Indexes for table `showtime`
--
ALTER TABLE `SHOWTIME` ADD PRIMARY KEY (`MOVIENAME`, `SHOWDATE`);

--
-- Indexes for table `ticket`
--
ALTER TABLE `TICKET` ADD PRIMARY KEY (`TICKETNUMBER`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ticket`
--
ALTER TABLE `TICKET` MODIFY `TICKETNUMBER` INT(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9689601;

COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;

/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;