CREATE TABLE post(
p_no INT PRIMARY KEY AUTO_INCREMENT,
user_id INT UNIQUE,
message VARCHAR(255) NOT NULL,
posted_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP 
);
SELECT*FROM post;
DROP TABLE post;

INSERT INTO post(user_id,message)
VALUES(1,"god is love"),
(2,"experience is the best teacher");