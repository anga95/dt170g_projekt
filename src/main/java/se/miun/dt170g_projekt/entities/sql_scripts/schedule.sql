drop table SCHEDULE;
drop table SHIFT;
drop table LEAVE_DAY;
drop table EXTRA_DAY;
drop table EMPLOYEE;

create table APP.EMPLOYEE
(

    ID        INTEGER GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)
        constraint "EMPLOYEE_pk" primary key,
    NAME      VARCHAR(50),
    DEVICE_ID VARCHAR(50),
    EMAIL     VARCHAR(50),
    PHONE     VARCHAR(50)
);

create table APP.SHIFT
(
    ID         INTEGER GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)
        constraint "SHIFT_pk" primary key,
    START_TIME TIME not null,
    END_TIME   TIME not null
);


create table APP.SCHEDULE
(
    ID     INTEGER GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)
        constraint "SCHEDULE_pk" primary key,
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
    ID         INTEGER GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)
        constraint "LEAVE_DAY_pk" primary key,
    EMP_ID     INTEGER not null
        constraint "LEAVE_DAY_EMPLOYEE_ID_fk"
            references APP.EMPLOYEE,
    LEAVE_DATE DATE    not null,
    START_TIME TIME    not null,
    END_TIME   TIME    not null
);

create table APP.EXTRA_DAY
(
    ID         INTEGER GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)
        constraint "EXTRA_DAY_pk" primary key,
    EMP_ID     INTEGER not null
        constraint "EXTRA_DAY_EMPLOYEE_ID_fk"
            references APP.EMPLOYEE,
    EXTRA_DATE DATE    not null,
    START_TIME TIME    not null,
    END_TIME   TIME    not null
);

insert into EMPLOYEE (NAME, DEVICE_ID, EMAIL, PHONE)
values ('John Doe', '1234567890', 'john@example.com', '1234567890');

insert into EMPLOYEE (NAME, DEVICE_ID, EMAIL, PHONE)
values ('Jane Doe', '0987654321', 'jan@example.com', '0987654321');

insert into EMPLOYEE (NAME, DEVICE_ID, EMAIL, PHONE)
values ('John Smith', '1234567890', 'johnsmith@example.com', '1234567890');

insert into EMPLOYEE (NAME, DEVICE_ID, EMAIL, PHONE)
values ('Karl Smith', '0987654321', 'karlsmith@example.com', '0987654321');

insert into SHIFT (START_TIME, END_TIME)
values ('08:00:00', '16:00:00');
insert into SHIFT (START_TIME, END_TIME)
values ('14:00:00', '20:00:00');
insert into SHIFT (START_TIME, END_TIME)
values ('16:00:00', '22:00:00');


insert into SCHEDULE (EMP_ID, MON, TUE, WED, THU, FRI, SAT, SUN)
values (3, 2, null, 3, null, 1, 1, null);
insert into SCHEDULE (EMP_ID, MON, TUE, WED, THU, FRI, SAT, SUN)
values (1, 2, 2, 3, 1, 2, null, null);
insert into SCHEDULE (EMP_ID, MON, TUE, WED, THU, FRI, SAT, SUN)
values (2, 2, 2, 3, 1, null, null, null);
insert into SCHEDULE (EMP_ID, MON, TUE, WED, THU, FRI, SAT, SUN)
values (4, 2, 2, 3, 1, null, 2, null);

-- random dates mars 2023, random shift times leave days
insert into LEAVE_DAY (EMP_ID, LEAVE_DATE, START_TIME, END_TIME)
values (1, '2023-03-08', '08:00:00', '16:00:00');
insert into LEAVE_DAY (EMP_ID, LEAVE_DATE, START_TIME, END_TIME)
values (1, '2023-03-09', '08:00:00', '16:00:00');
insert into LEAVE_DAY (EMP_ID, LEAVE_DATE, START_TIME, END_TIME)
values (1, '2023-03-21', '14:00:00', '20:00:00');
insert into LEAVE_DAY (EMP_ID, LEAVE_DATE, START_TIME, END_TIME)
values (1, '2023-03-24', '14:00:00', '20:00:00');

insert into LEAVE_DAY (EMP_ID, LEAVE_DATE, START_TIME, END_TIME)
values (2, '2023-03-01', '08:00:00', '16:00:00');
insert into LEAVE_DAY (EMP_ID, LEAVE_DATE, START_TIME, END_TIME)
values (2, '2023-03-02', '08:00:00', '16:00:00');

insert into LEAVE_DAY (EMP_ID, LEAVE_DATE, START_TIME, END_TIME)
values (3, '2023-03-11', '08:00:00', '16:00:00');
insert into LEAVE_DAY (EMP_ID, LEAVE_DATE, START_TIME, END_TIME)
values (3, '2023-03-22', '16:00:00', '22:00:00');
insert into LEAVE_DAY (EMP_ID, LEAVE_DATE, START_TIME, END_TIME)
values (3, '2023-03-23', '08:00:00', '16:00:00');

insert into LEAVE_DAY (EMP_ID, LEAVE_DATE, START_TIME, END_TIME)
values (4, '2023-03-28', '08:00:00', '16:00:00');

-- random dates mars 2023, random shift times extra days
insert into EXTRA_DAY (EMP_ID, EXTRA_DATE, START_TIME, END_TIME)
values (1, '2023-03-01', '08:00:00', '16:00:00');
insert into EXTRA_DAY (EMP_ID, EXTRA_DATE, START_TIME, END_TIME)
values (1, '2023-03-02', '08:00:00', '16:00:00');
insert into EXTRA_DAY (EMP_ID, EXTRA_DATE, START_TIME, END_TIME)
values (1, '2023-03-03', '08:00:00', '16:00:00');
insert into EXTRA_DAY (EMP_ID, EXTRA_DATE, START_TIME, END_TIME)
values (1, '2023-03-04', '08:00:00', '16:00:00');

insert into EXTRA_DAY (EMP_ID, EXTRA_DATE, START_TIME, END_TIME)
values (2, '2023-03-05', '08:00:00', '16:00:00');
insert into EXTRA_DAY (EMP_ID, EXTRA_DATE, START_TIME, END_TIME)
values (2, '2023-03-06', '08:00:00', '16:00:00');

insert into EXTRA_DAY (EMP_ID, EXTRA_DATE, START_TIME, END_TIME)
values (3, '2023-03-07', '08:00:00', '16:00:00');
insert into EXTRA_DAY (EMP_ID, EXTRA_DATE, START_TIME, END_TIME)
values (3, '2023-03-08', '08:00:00', '16:00:00');
insert into EXTRA_DAY (EMP_ID, EXTRA_DATE, START_TIME, END_TIME)
values (3, '2023-03-09', '08:00:00', '16:00:00');

insert into EXTRA_DAY (EMP_ID, EXTRA_DATE, START_TIME, END_TIME)
values (4, '2023-03-09', '08:00:00', '16:00:00');
