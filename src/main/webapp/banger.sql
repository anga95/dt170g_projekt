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
      hourly_rate INTEGER NOT NULL,
      start_date TIMESTAMP NOT NULL
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

CREATE TABLE APP.DISHES (
  id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  description VARCHAR(255),
  price DECIMAL(10, 2),
  cookTime INTEGER
);

INSERT INTO dishes (description, price, cookTime)
VALUES ('Spaghetti Bolognese', 12.99, 30);

INSERT INTO dishes (description, price, cookTime)
VALUES ('Fish and Chips', 15.99, 25);


create table APP.orders
(
    ID           INTEGER generated always as identity
        constraint orders_pk
            primary key,
    TABLE_NUMBER INTEGER not null,
    NOTES       VARCHAR(255)
);

create table APP.DRINKS
(
    ID             INTEGER generated always as identity
        constraint "DRINKS_pk"
            primary key,
    ORDER_ID       INTEGER
        constraint "DRINKS_ORDERS_ID_fk"
            references ORDERS,
    QUANTITY       INTEGER,
    READY_TO_SERVE BOOLEAN default FALSE
);
create table APP.STARTERS
(
    ID             INTEGER generated always as identity
        constraint "STARTERS_pk"
            primary key,
    ORDER_ID       INTEGER
        constraint "STARTERS_ORDERS_ID_fk"
            references ORDERS,
    QUANTITY       INTEGER,
    READY_TO_SERVE BOOLEAN default FALSE
);
create table APP.MAIN_COURSES
(
    ID             INTEGER generated always as identity
        constraint "MAIN_COURSES_pk"
            primary key,
    ORDER_ID       INTEGER
        constraint "MAIN_COURSES_ORDERS_ID_fk"
            references ORDERS,
    QUANTITY       INTEGER,
    READY_TO_SERVE BOOLEAN default FALSE
);
create table APP.DESSERTS
(
    ID             INTEGER generated always as identity
        constraint "DESSERTS_pk"
            primary key,
    ORDER_ID       INTEGER
        constraint "DESSERTS_ORDERS_ID_fk"
            references ORDERS,
    QUANTITY       INTEGER,
    READY_TO_SERVE BOOLEAN default FALSE
);

create table APP.DAILY_LUNCH
(
    id      INTEGER generated always as identity
        constraint daily_lunch_pk
            primary key,
    weekday varchar(25),
    lunch_1 varchar(250),
    lunch_2 varchar(250),
    lunch_3 varchar(250)
);
INSERT INTO APP.daily_lunch (weekday, lunch_1, lunch_2, lunch_3)
VALUES
    ('Måndag', 'Köttbullar med lingonsås och potatismos', 'Gravad lax med dillsås och kokt potatis', 'Vegetarisk ärtsoppa med krutonger'),
    ('Tisdag', 'Pyttipanna (stekt potatis med lök och kött)', 'Fish and chips med remouladesås', 'Vegetarisk lasagne'),
    ('Onsdag', 'Grillad kyckling med rostade rotfrukter', 'Stekt strömming med potatismos och lingon', 'Vegetarisk quinoasallad med fetaost och rödbetor'),
    ('Torsdag', 'Svenska köttbullar med gräddsås och potatismos', 'Räksallad med kokt ägg och avokado', 'Vegetarisk linssoppa'),
    ('Fredag', 'Janssons frestelse (potatisgratäng med ansjovis)', 'Gryta med nötkött och rotfrukter', 'Vegetarisk svamp risotto');

