-- Drop the user 'springstudent' if they already exist
DROP USER IF EXISTS 'springstudent'@'localhost';

-- Create a new user 'springstudent' with a password 'springstudent'
CREATE USER 'springstudent'@'localhost' IDENTIFIED BY 'springstudent';

-- Grant all privileges to the 'springstudent' user for all tables in all databases
GRANT ALL PRIVILEGES ON * . * TO 'springstudent'@'localhost';
