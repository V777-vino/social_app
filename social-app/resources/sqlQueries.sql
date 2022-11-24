CREATE TABLE USER(
user_id INT PRIMARY KEY AUTO_INCREMENT,
user_name VARCHAR(100) NOT NULL,
user_email VARCHAR(100)NOT NULL,
mobile_no BIGINT NOT NULL,
PASSWORD VARCHAR(10) NOT NULL,
gender CHAR(1) NOT NULL,
dob DATE NOT NULL,
created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
UNIQUE(user_email),
UNIQUE(mobile_no),
CHECK(gender IN('M','F'))
);
SELECT*FROM USER;
SELECT*FROM post;
DROP TABLE USER;
INSERT INTO USER(user_name,user_email,mobileNo,PASSWORD,gender,dob)VALUES();
DELETE FROM USER WHERE user_id = 1
INSERT INTO USER(user_name,user_email,mobile_no,PASSWORD,gender,dob)VALUES("raj","r@gmail.com","8189880558","pass1234",'M',"1998-06-26");
UPDATE USER SET PASSWORD = "pass777" WHERE user_id = 2;
SELECT user_name,user_email,PASSWORD FROM USER WHERE user_email = "r@gmail.com" AND PASSWORD ="pass123"; 
INSERT INTO post(user_id,message) VALUES (3,"tit for tat");
