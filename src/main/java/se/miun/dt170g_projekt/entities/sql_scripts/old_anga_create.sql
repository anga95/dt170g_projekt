CREATE TABLE TEST.RESTAURANT (
    ID INT PRIMARY KEY,
    NAME VARCHAR(255)
);
INSERT INTO APP.RESTAURANT (ID, NAME)
VALUES (1, 'antons skafferi');

create table APP.employee
(
    id         INTEGER generated always as identity
        constraint employee_pk
            primary key,
    first_name varchar(50),
    last_name  varchar(50),
    email      varchar(50),
    telephone  varchar(50),
    rest_id_fk INTEGER
        constraint "employee_RESTAURANT_ID_fk"
            references RESTAURANT
);

INSERT INTO APP.EMPLOYEE (EMAIL, FIRST_NAME, LAST_NAME, rest_id_fk, TELEPHONE)
VALUES ('kalle@gmail.com', 'kalle', 'nilsson', 1, '11111'),
       ('lisa@gmail.com', 'lisa', 'nilsson', 1, '22222'),
       ('anders@gmail.com', 'anders', 'larsson', 1, '33333'),
       ('mayeb@gmail.com', 'mayeb', 'naleki', 1, '44444');
