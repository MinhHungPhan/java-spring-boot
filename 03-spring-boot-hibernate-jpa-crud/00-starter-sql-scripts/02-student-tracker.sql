-- Create student_tracker database if it doesn't exist
CREATE DATABASE  IF NOT EXISTS `student_tracker`;

-- Use student_tracker database
USE `student_tracker`;

-- Drop the student table if it exists
DROP TABLE IF EXISTS `student`;

-- Create student table with four fields: id, first_name, last_name, email
CREATE TABLE `student` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name`varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

