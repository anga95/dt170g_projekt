
CREATE TABLE TEST.RESTAURANT (
    ID INT PRIMARY KEY,
    NAME VARCHAR(255)
);
INSERT INTO TEST.RESTAURANT (ID, NAME)
VALUES (1, 'antons skafferi');

CREATE TABLE TEST.employee (
      id INTEGER GENERATED ALWAYS AS IDENTITY constraint employee_pk PRIMARY KEY,
      first_name VARCHAR(255) NOT NULL,
      last_name VARCHAR(255) NOT NULL,
      email VARCHAR(255) NOT NULL,
      phone VARCHAR(255) NOT NULL,
      hourly_rate INTEGER NOT NULL,
      start_date TIMESTAMP NOT NULL
);
INSERT INTO TEST.employee (first_name, last_name, email, phone, hourly_rate, start_date)
VALUES
    ('John', 'Doe', 'johndoe@example.com', '123456789', 100, '2022-02-01 08:00:00'),
    ('Jane', 'Doe', 'janedoe@example.com', '234567890', 90, '2022-02-01 08:00:00'),
    ('Bob', 'Smith', 'bobsmith@example.com', '345678901', 95, '2022-02-01 08:00:00'),
    ('Alice', 'Johnson', 'alicejohnson@example.com', '456789012', 110, '2022-02-01 08:00:00'),
    ('Michael', 'Brown', 'michaelbrown@example.com', '567890123', 85, '2022-02-01 08:00:00'),
    ('Sarah', 'Wilson', 'sarahwilson@example.com', '678901234', 95, '2022-02-01 08:00:00'),
    ('David', 'Taylor', 'davidtaylor@example.com', '789012345', 100, '2022-02-01 08:00:00'),
    ('Emily', 'Clark', 'emilyclark@example.com', '890123456', 105, '2022-02-01 08:00:00');


CREATE TABLE TEST.shift (
       id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
       shift_name VARCHAR(255) NOT NULL,
       start_time TIME NOT NULL,
       end_time TIME NOT NULL
);


CREATE TABLE TEST.EMPLOYEE_SCHEDULE (
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
       FOREIGN KEY (EMP_ID) REFERENCES TEST.EMPLOYEE (ID),
       FOREIGN KEY (V_ONE_MONDAY) REFERENCES TEST.SHIFT (ID),
       FOREIGN KEY (V_ONE_TUESDAY) REFERENCES TEST.SHIFT (ID),
       FOREIGN KEY (V_ONE_WEDNESDAY) REFERENCES TEST.SHIFT (ID),
       FOREIGN KEY (V_ONE_THURSDAY) REFERENCES TEST.SHIFT (ID),
       FOREIGN KEY (V_ONE_FRIDAY) REFERENCES TEST.SHIFT (ID),
       FOREIGN KEY (V_ONE_SATURDAY) REFERENCES TEST.SHIFT (ID),
       FOREIGN KEY (V_ONE_SUNDAY) REFERENCES TEST.SHIFT (ID),
       FOREIGN KEY (V_TWO_MONDAY) REFERENCES TEST.SHIFT (ID),
       FOREIGN KEY (V_TWO_TUESDAY) REFERENCES TEST.SHIFT (ID),
       FOREIGN KEY (V_TWO_WEDNESDAY) REFERENCES TEST.SHIFT (ID),
       FOREIGN KEY (V_TWO_THURSDAY) REFERENCES TEST.SHIFT (ID),
       FOREIGN KEY (V_TWO_FRIDAY) REFERENCES TEST.SHIFT (ID),
       FOREIGN KEY (V_TWO_SATURDAY) REFERENCES TEST.SHIFT (ID),
       FOREIGN KEY (V_TWO_SUNDAY) REFERENCES TEST.SHIFT (ID)
);

create table TEST.daily_lunch
(
    id      INTEGER generated always as identity
        constraint daily_lunch_pk
            primary key,
    weekday varchar(25),
    lunch_1 varchar(250),
    lunch_2 varchar(250),
    lunch_3 varchar(250)
);
INSERT INTO TEST.daily_lunch (weekday, lunch_1, lunch_2, lunch_3)
VALUES
    ('Måndag', 'Köttbullar med lingonsås och potatismos', 'Gravad lax med dillsås och kokt potatis', 'Vegetarisk ärtsoppa med krutonger'),
    ('Tisdag', 'Pyttipanna (stekt potatis med lök och kött)', 'Fish and chips med remouladesås', 'Vegetarisk lasagne'),
    ('Onsdag', 'Grillad kyckling med rostade rotfrukter', 'Stekt strömming med potatismos och lingon', 'Vegetarisk quinoasallad med fetaost och rödbetor'),
    ('Torsdag', 'Svenska köttbullar med gräddsås och potatismos', 'Räksallad med kokt ägg och avokado', 'Vegetarisk linssoppa'),
    ('Fredag', 'Janssons frestelse (potatisgratäng med ansjovis)', 'Gryta med nötkött och rotfrukter', 'Vegetarisk svamp risotto');
