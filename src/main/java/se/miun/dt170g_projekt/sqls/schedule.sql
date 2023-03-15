drop table SCHEDULE;
drop table SHIFT;
drop table LEAVE_DAY;
drop table EXTRA_DAY;
drop table EMPLOYEE;

create table APP.EMPLOYEE
(
    ID          INTEGER GENERATED ALWAYS AS IDENTITY
        constraint EMPLOYEE_pk PRIMARY KEY,
    FIRST_NAME  VARCHAR(50) not null,
    LAST_NAME   VARCHAR(50) not null,
    DEVICE_ID   VARCHAR(50) not null,
    EMAIL       VARCHAR(50) not null,
    PHONE       VARCHAR(50) not null,
    START_DATE  DATE        not null,
    HOURLY_RATE INTEGER     not null
);

create table APP.SHIFT
(
    ID         INTEGER GENERATED ALWAYS AS IDENTITY
        constraint SHIFT_pk PRIMARY KEY,
    SHIFT_NAME VARCHAR(50) not null,
    START_TIME TIME        not null,
    END_TIME   TIME        not null
);


create table APP.SCHEDULE
(
    ID     INTEGER GENERATED ALWAYS AS IDENTITY
        constraint SCHEDULE_pk PRIMARY KEY,
    EMP_ID INTEGER not null
        constraint "SCHEDULE_EMPLOYEE_ID_fk"
            references APP.EMPLOYEE,
    MON    INTEGER
        constraint "SCHEDULE_SHIFT_ID_fk"
            references APP.SHIFT,
    TUE    INTEGER
        constraint "SCHEDULE_SHIFT_ID_fk2"
            references APP.SHIFT,
    WED    INTEGER
        constraint "SCHEDULE_SHIFT_ID_fk3"
            references APP.SHIFT,
    THU    INTEGER
        constraint "SCHEDULE_SHIFT_ID_fk4"
            references APP.SHIFT,
    FRI    INTEGER
        constraint "SCHEDULE_SHIFT_ID_fk5"
            references APP.SHIFT,
    SAT    INTEGER
        constraint "SCHEDULE_SHIFT_ID_fk6"
            references APP.SHIFT,
    SUN    INTEGER
        constraint "SCHEDULE_SHIFT_ID_fk7"
            references APP.SHIFT
);


create table APP.LEAVE_DAY
(

    ID         INTEGER GENERATED ALWAYS AS IDENTITY
        constraint LEAVE_DAY_pk PRIMARY KEY,
    EMP_ID     INTEGER not null
        constraint "LEAVE_DAY_EMPLOYEE_ID_fk"
            references APP.EMPLOYEE,
    LEAVE_DATE DATE    not null,
    SHIFT      INTEGER not null
        constraint "LEAVE_DAY_SHIFT_ID_fk"
            references APP.SHIFT
);

create table APP.EXTRA_DAY
(
    ID         INTEGER GENERATED ALWAYS AS IDENTITY
        constraint EXTRA_DAY_pk PRIMARY KEY,
    EMP_ID     INTEGER not null
        constraint "EXTRA_DAY_EMPLOYEE_ID_fk"
            references APP.EMPLOYEE,
    EXTRA_DATE DATE    not null,
    SHIFT      INTEGER not null
        constraint "EXTRA_DAY_SHIFT_ID_fk"
            references APP.SHIFT
);

insert into EMPLOYEE (FIRST_NAME, LAST_NAME, DEVICE_ID, EMAIL, PHONE, HOURLY_RATE, START_DATE)
values ('John', 'Doe', '123456789', 'john@gmail.com', '123456789', 10, '2020-01-01'),
       ('Jane', 'Doe', '123456789', 'jane@gmail.com', '123456789', 10, '2020-01-01'),
       ('John', 'Smith', '123456789', 'john@gmail.com', '123456789', 10, '2020-01-01'),
       ('Jane', 'Smith', '123456789', 'jane@gmail.com', '123456789', 10, '2020-01-01'),
       ('Tina', 'Smith', '123456789', 'tina@gmail.com', '123456789', 10, '2020-01-01'),
       ('Karl', 'Anderson', '123456789', 'karl@android.com', '123456789', 10, '2020-01-01');

insert into SHIFT (SHIFT_NAME, START_TIME, END_TIME)
values ('Morgon', '08:00:00', '16:00:00'),
       ('Lunch', '14:00:00', '20:00:00'),
       ('Kväll', '16:00:00', '22:00:00');


insert into SCHEDULE (EMP_ID, MON, TUE, WED, THU, FRI, SAT, SUN)
values (3, 2, null, 3, null, 1, 1, null),
       (1, 3, 2, 3, 1, 2, null, null),
       (2, null, 2, 3, 1, null, null, null),
       (5, 1, 2, null, 1, 3, null, null),
       (6, null, 2, 3, 1, null, null, null),
       (4, 2, 2, 3, 1, null, 2, null);

-- random dates mars 2023, random shift times leave days
insert into LEAVE_DAY (EMP_ID, LEAVE_DATE, SHIFT)
values (1, '2023-03-08', 3),
       (1, '2023-03-09', 1),
       (1, '2023-03-21', 3),
       (1, '2023-03-24', 1),

       (2, '2023-03-01', 2),
       (2, '2023-03-02', 3),

       (3, '2023-03-11', 1),
       (3, '2023-03-22', 2),
       (3, '2023-03-23', 3),

       (4, '2023-03-28', 3);

-- random dates mars 2023, random shift times extra days
insert into EXTRA_DAY (EMP_ID, EXTRA_DATE, SHIFT)
values (1, '2023-03-01', 2),
       (1, '2023-03-02', 1),
       (1, '2023-03-03', 2),
       (1, '2023-03-04', 3),

       (2, '2023-03-05', 1),
       (2, '2023-03-06', 3),

       (3, '2023-03-07', 3),
       (3, '2023-03-08', 1),
       (3, '2023-03-09', 2),

       (4, '2023-03-09', 2);