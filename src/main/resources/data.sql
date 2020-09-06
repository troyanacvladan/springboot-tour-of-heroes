DROP TABLE IF EXISTS hero;

CREATE TABLE hero (
 id INT AUTO_INCREMENT  PRIMARY KEY,
 name VARCHAR(250) NOT NULL
);




INSERT INTO hero
    (id,name)
VALUES
    (1,'Hero1'),
    (2,'Hero2'),
    (3,'Hero3'),
    (4,'Hero4'),
    (5,'Hero5');