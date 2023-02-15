create table "Employee"
(
    ID            INTEGER not null
        constraint "Employee_pk"
            primary key,
    FIRST_NAME    VARCHAR(50),
    LAST_NAME     VARCHAR(50),
    TELEPHONE     VARCHAR(50),
    RESTAURANT_ID INTEGER
        constraint "Employee_RESTAURANT_ID_fk"
            references RESTAURANT
);

