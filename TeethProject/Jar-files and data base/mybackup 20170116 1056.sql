-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.35-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema doctor
--

CREATE DATABASE IF NOT EXISTS doctor;
USE doctor;

--
-- Definition of table `admins`
--

DROP TABLE IF EXISTS `admins`;
CREATE TABLE `admins` (
  `name` varchar(35) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`name`) USING BTREE,
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admins`
--

/*!40000 ALTER TABLE `admins` DISABLE KEYS */;
INSERT INTO `admins` (`name`,`password`) VALUES 
 ('admin','11'),
 ('Maryam','321'),
 ('Jwan','123'),
 ('sara','123'),
 ('sanaa','1234'),
 ('samar','1234'),
 ('soad','0000');
/*!40000 ALTER TABLE `admins` ENABLE KEYS */;


--
-- Definition of table `lab`
--

DROP TABLE IF EXISTS `lab`;
CREATE TABLE `lab` (
  `lab_id` int(11) NOT NULL AUTO_INCREMENT,
  `lab_patient_id` int(11) NOT NULL,
  `date` date NOT NULL,
  `color` varchar(15) NOT NULL,
  `delivery` varchar(60) NOT NULL,
  `no_of_teeth` int(11) NOT NULL,
  `teeth` varchar(70) NOT NULL,
  `amount` int(11) NOT NULL,
  `paid` int(11) NOT NULL,
  PRIMARY KEY (`lab_id`),
  KEY `patient_id_idx` (`lab_patient_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lab`
--

/*!40000 ALTER TABLE `lab` DISABLE KEYS */;
INSERT INTO `lab` (`lab_id`,`lab_patient_id`,`date`,`color`,`delivery`,`no_of_teeth`,`teeth`,`amount`,`paid`) VALUES 
 (1,1,'2012-01-17','red','ontime',2,'4',200,10);
/*!40000 ALTER TABLE `lab` ENABLE KEYS */;


--
-- Definition of table `lab_patients`
--

DROP TABLE IF EXISTS `lab_patients`;
CREATE TABLE `lab_patients` (
  `patient_id` int(11) NOT NULL AUTO_INCREMENT,
  `patient_name` varchar(45) NOT NULL,
  PRIMARY KEY (`patient_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lab_patients`
--

/*!40000 ALTER TABLE `lab_patients` DISABLE KEYS */;
INSERT INTO `lab_patients` (`patient_id`,`patient_name`) VALUES 
 (1,'Faleh');
/*!40000 ALTER TABLE `lab_patients` ENABLE KEYS */;


--
-- Definition of table `patients`
--

DROP TABLE IF EXISTS `patients`;
CREATE TABLE `patients` (
  `patient_id` int(11) NOT NULL AUTO_INCREMENT,
  `patient_name` varchar(45) NOT NULL,
  `address` varchar(100) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `total_amount` int(11) NOT NULL,
  `total_paid` int(11) NOT NULL,
  `added_by` varchar(11) NOT NULL,
  PRIMARY KEY (`patient_id`),
  KEY `added_by_idx` (`added_by`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patients`
--

/*!40000 ALTER TABLE `patients` DISABLE KEYS */;
/*!40000 ALTER TABLE `patients` ENABLE KEYS */;


--
-- Definition of table `secretary`
--

DROP TABLE IF EXISTS `secretary`;
CREATE TABLE `secretary` (
  `sec_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(35) NOT NULL,
  `password` varchar(20) NOT NULL,
  `adminId` varchar(35) DEFAULT NULL,
  PRIMARY KEY (`sec_id`),
  KEY `adminId` (`adminId`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `secretary`
--

/*!40000 ALTER TABLE `secretary` DISABLE KEYS */;
INSERT INTO `secretary` (`sec_id`,`name`,`password`,`adminId`) VALUES 
 (1,'safaa','111',''),
 (2,'rajaa','111',''),
 (4,'lama','124',''),
 (5,'salwa','133',''),
 (6,'lyla','123',''),
 (7,'roaa','1234',NULL),
 (8,'Lamia','12344',NULL);
/*!40000 ALTER TABLE `secretary` ENABLE KEYS */;


--
-- Definition of table `visits`
--

DROP TABLE IF EXISTS `visits`;
CREATE TABLE `visits` (
  `visit_id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `pacient_id` int(11) NOT NULL,
  `medicen` varchar(250) NOT NULL,
  `comments` varchar(250) DEFAULT NULL,
  `amount` int(11) NOT NULL,
  `paid` int(11) NOT NULL,
  `teeth` varchar(45) NOT NULL,
  PRIMARY KEY (`visit_id`),
  KEY `patient_idx` (`pacient_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `visits`
--

/*!40000 ALTER TABLE `visits` DISABLE KEYS */;
/*!40000 ALTER TABLE `visits` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
