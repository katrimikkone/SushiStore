SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS category; 
DROP TABLE IF EXISTS sushi; 
DROP TABLE IF EXISTS app_user;
SET FOREIGN_KEY_CHECKS=1;

CREATE TABLE category (
categoryid BIGINT NOT NULL AUTO_INCREMENT
, name VARCHAR(50) NOT NULL
, PRIMARY KEY(categoryid)
);

INSERT INTO category (name)
VALUES ("maki"), ("nigiri"), ("sashimi"), ("temaki");

CREATE TABLE sushi (
id BIGINT NOT NULL AUTO_INCREMENT
, name VARCHAR(100) NOT NULL
, description VARCHAR(150) NOT NULL
, price BIGINT(5) NOT NULL
, categoryid BIGINT
, PRIMARY KEY (id)
, FOREIGN KEY(categoryid) REFERENCES category(categoryid)
);

INSERT INTO sushi (name, description, price, categoryid)
VALUES ("sake", "salmon", 3.00, 1), ("tamago", "egg", 2.00, 2), ("ebi", "shrimp", 2.00, 2);

CREATE TABLE app_user (
id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY
, username VARCHAR(100) NOT NULL
, password VARCHAR(100) NOT NULL
, role VARCHAR(100) NOT NULL
);

INSERT INTO app_user (username, password, role)
VALUES ("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER"),
("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");

SELECT * FROM sushi;
SELECT * FROM category;
SELECT * FROM app_user;