
CREATE TABLE APP.RESTAURANT (
    ID INT PRIMARY KEY,
    NAME VARCHAR(255)
);
INSERT INTO APP.RESTAURANT (ID, NAME)
VALUES (1, 'antons skafferi');

CREATE TABLE APP.employee (
      id INTEGER GENERATED ALWAYS AS IDENTITY constraint employee_pk PRIMARY KEY,
      first_name VARCHAR(255) NOT NULL,
      last_name VARCHAR(255) NOT NULL,
      email VARCHAR(255) NOT NULL,
      phone VARCHAR(255) NOT NULL,
      hourly_rate INTEGER,
      start_date TIMESTAMP
);
INSERT INTO APP.employee (first_name, last_name, email, phone, hourly_rate, start_date)
VALUES
    ('John', 'Doe', 'johndoe@example.com', '123456789', 100, '2022-02-01 08:00:00'),
    ('Jane', 'Doe', 'janedoe@example.com', '234567890', 90, '2022-02-01 08:00:00'),
    ('Bob', 'Smith', 'bobsmith@example.com', '345678901', 95, '2022-02-01 08:00:00'),
    ('Alice', 'Johnson', 'alicejohnson@example.com', '456789012', 110, '2022-02-01 08:00:00'),
    ('Michael', 'Brown', 'michaelbrown@example.com', '567890123', 85, '2022-02-01 08:00:00'),
    ('Sarah', 'Wilson', 'sarahwilson@example.com', '678901234', 95, '2022-02-01 08:00:00'),
    ('David', 'Taylor', 'davidtaylor@example.com', '789012345', 100, '2022-02-01 08:00:00'),
    ('Emily', 'Clark', 'emilyclark@example.com', '890123456', 105, '2022-02-01 08:00:00');


CREATE TABLE APP.shift (
       id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
       shift_name VARCHAR(255) NOT NULL,
       start_time TIME NOT NULL,
       end_time TIME NOT NULL
);


CREATE TABLE APP.EMPLOYEE_SCHEDULE (
       ID INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
       EMP_ID INTEGER NOT NULL,
       V_ONE_MONDAY BIGINT NOT NULL,
       V_ONE_TUESDAY BIGINT NOT NULL,
       V_ONE_WEDNESDAY BIGINT NOT NULL,
       V_ONE_THURSDAY BIGINT NOT NULL,
       V_ONE_FRIDAY BIGINT NOT NULL,
       V_ONE_SATURDAY BIGINT NOT NULL,
       V_ONE_SUNDAY BIGINT NOT NULL,
       V_TWO_MONDAY BIGINT NOT NULL,
       V_TWO_TUESDAY BIGINT NOT NULL,
       V_TWO_WEDNESDAY BIGINT NOT NULL,
       V_TWO_THURSDAY BIGINT NOT NULL,
       V_TWO_FRIDAY BIGINT NOT NULL,
       V_TWO_SATURDAY BIGINT NOT NULL,
       V_TWO_SUNDAY BIGINT NOT NULL,
       FOREIGN KEY (EMP_ID) REFERENCES APP.EMPLOYEE (ID),
       FOREIGN KEY (V_ONE_MONDAY) REFERENCES APP.SHIFT (ID),
       FOREIGN KEY (V_ONE_TUESDAY) REFERENCES APP.SHIFT (ID),
       FOREIGN KEY (V_ONE_WEDNESDAY) REFERENCES APP.SHIFT (ID),
       FOREIGN KEY (V_ONE_THURSDAY) REFERENCES APP.SHIFT (ID),
       FOREIGN KEY (V_ONE_FRIDAY) REFERENCES APP.SHIFT (ID),
       FOREIGN KEY (V_ONE_SATURDAY) REFERENCES APP.SHIFT (ID),
       FOREIGN KEY (V_ONE_SUNDAY) REFERENCES APP.SHIFT (ID),
       FOREIGN KEY (V_TWO_MONDAY) REFERENCES APP.SHIFT (ID),
       FOREIGN KEY (V_TWO_TUESDAY) REFERENCES APP.SHIFT (ID),
       FOREIGN KEY (V_TWO_WEDNESDAY) REFERENCES APP.SHIFT (ID),
       FOREIGN KEY (V_TWO_THURSDAY) REFERENCES APP.SHIFT (ID),
       FOREIGN KEY (V_TWO_FRIDAY) REFERENCES APP.SHIFT (ID),
       FOREIGN KEY (V_TWO_SATURDAY) REFERENCES APP.SHIFT (ID),
       FOREIGN KEY (V_TWO_SUNDAY) REFERENCES APP.SHIFT (ID)
);

create table APP.daily_lunch
(
    id      INTEGER generated always as identity
        constraint daily_lunch_pk
            primary key,
    weekday varchar(25),
    lunch_1 varchar(250),
    lunch_2 varchar(250),
    lunch_3 varchar(250),
    PRICE   INTEGER,
    TIME    INTEGER
);
create table APP.booking
(
    id      INTEGER generated always as identity
        constraint booking_pk
            primary key,
    date varchar(25),
    time varchar(25),
    fname varchar(25),
    lname varchar(25),
    telnumber varchar(25),
    email varchar(25),
    number_of_people varchar(25),
    extra varchar(25)
);

