create table RESTAURANT
(
    ID   INTEGER default AUTOINCREMENT: start 1 increment 1 generated always as identity
        constraint "RESTAURANT_pk"
        primary key,
    NAME VARCHAR(50)
);

create table EMPLOYEE
(
    ID            INTEGER default AUTOINCREMENT: start 1 increment 1 generated always as identity
        constraint "EMPLOYEE_pk"
        primary key,
    FIRST_NAME    VARCHAR(50),
    LAST_NAME     VARCHAR(50),
    TELEPHONE     VARCHAR(50),
    RESTAURANT_ID INTEGER
        constraint "EMPLOYEE_RESTAURANT_ID_fk"
            references RESTAURANT
);

create table PERSONAL_SCHEDULE
(
    ID          INTEGER default AUTOINCREMENT: start 1 increment 1 generated always as identity
        constraint "PERSONAL_SCHEDULE_pk"
        primary key,
    DATE        VARCHAR(50),
    START_TIME  VARCHAR(50),
    END_TIME    VARCHAR(50),
    DESCRIPTION VARCHAR(200),
    EMPLOYEE_ID INTEGER
        constraint "PERSONAL_SCHEDULE_EMPLOYEE_ID_fk"
            references EMPLOYEE
);

create table SCHEDULE
(
    ID       INTEGER not null
        constraint "SCHEDULE_pk"
            primary key,
    DATE     VARCHAR(50),
    EMPLOYEE VARCHAR(50)
);


