create table EMPLOYEE
(
    ID         INTEGER default AUTOINCREMENT: start 1 increment 1 generated always as identity
        constraint "EMPLOYEE_pk"
        primary key,
    NAME       VARCHAR(50),
    FIRST_NAME VARCHAR(50),
    LAST_NAME  VARCHAR(50),
    TELEPHONE  VARCHAR(50)
);

