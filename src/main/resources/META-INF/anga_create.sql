CREATE TABLE APP.RESTAURANT (
                                ID INT PRIMARY KEY,
                                NAME VARCHAR(255)
);

CREATE TABLE APP.EMPLOYEE (
                              ID INT PRIMARY KEY,
                              EMAIL VARCHAR(255),
                              FIRST_NAME VARCHAR(255),
                              LAST_NAME VARCHAR(255),
                              RESTAURANT_ID INT,
                              TELEPHONE VARCHAR(20)
);

INSERT INTO APP.RESTAURANT (ID, NAME) VALUES (1, 'antons skafferi');

INSERT INTO APP.EMPLOYEE (ID, EMAIL, FIRST_NAME, LAST_NAME, RESTAURANT_ID, TELEPHONE)
VALUES (1, 'kalle@gmail.com', 'kalle', 'nilsson', 1, '11111'),
       (2, 'lisa@gmail.com', 'lisa', 'nilsson', 1, '22222'),
       (3, 'anders@gmail.com', 'anders', 'larsson', 1, '33333'),
       (4, 'mayeb@gmail.com', 'mayeb', 'naleki', 1, '44444');
