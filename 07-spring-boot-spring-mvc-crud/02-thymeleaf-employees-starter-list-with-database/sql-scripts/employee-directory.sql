CREATE DATABASE  IF NOT EXISTS `employee_directory`;
USE `employee_directory`;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `employee`
--

INSERT INTO `employee` VALUES 
	(1,'Albus','Dumbledore','albus.dumbledore@kientree.com'),
	(2,'Harry','Potter','harry.potter@kientree.com'),
	(3,'Hermione','Granger','hermione.granger@kientree.com'),
	(4,'Ron','Weasley','ron.weasley@kientree.com'),
	(5,'Draco','Malfoy','draco.malfoy@kientree.com');

