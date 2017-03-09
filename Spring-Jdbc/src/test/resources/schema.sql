CREATE TABLE IF NOT EXISTS `users` (`userName` VARCHAR(20),`password` VARCHAR (30));
CREATE TABLE IF NOT EXISTS `employee` (`empId` INTEGER(10) IDENTITY PRIMARY KEY, empName VARCHAR(20), department VARCHAR(20), supervisor VARCHAR(30));
INSERT INTO users (userName, password) VALUES ('admin','admin');
INSERT INTO employee (empId, empName, department, supervisor) VALUES (42433,'John Daly','Market','Mc O"Donne');
INSERT INTO employee (empId, empName, department, supervisor) VALUES (42434,'Henry Doe','Market','Mc O"Donne');