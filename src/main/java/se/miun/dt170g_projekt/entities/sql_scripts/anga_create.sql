
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
    lunch_3 varchar(250)
);
INSERT INTO APP.daily_lunch (weekday, lunch_1, lunch_2, lunch_3)
VALUES
    ('Måndag', 'Köttbullar med lingonsås och potatismos', 'Gravad lax med dillsås och kokt potatis', 'Vegetarisk ärtsoppa med krutonger'),
    ('Tisdag', 'Pyttipanna (stekt potatis med lök och kött)', 'Fish and chips med remouladesås', 'Vegetarisk lasagne'),
    ('Onsdag', 'Grillad kyckling med rostade rotfrukter', 'Stekt strömming med potatismos och lingon', 'Vegetarisk quinoasallad med fetaost och rödbetor'),
    ('Torsdag', 'Svenska köttbullar med gräddsås och potatismos', 'Räksallad med kokt ägg och avokado', 'Vegetarisk linssoppa'),
    ('Fredag', 'Janssons frestelse (potatisgratäng med ansjovis)', 'Gryta med nötkött och rotfrukter', 'Vegetarisk svamp risotto');

CREATE TABLE APP.Dessert
(
    ID INTEGER GENERATED ALWAYS AS IDENTITY,
    "Price" INTEGER,
    "Description" VARCHAR(50),
    CONSTRAINT "Dessert_pk" PRIMARY KEY (ID)
);

INSERT INTO APP.Dessert ("Price", "Description")
VALUES
    (5, 'Chocolate cake'),
    (4, 'Cheesecake'),
    (6, 'Tiramisu'),
    (3, 'Fruit salad');

CREATE TABLE APP.Drinks
(
    ID INTEGER GENERATED ALWAYS AS IDENTITY,
    "Price" INTEGER,
    "Description" VARCHAR(50),
    CONSTRAINT "Drinks_pk" PRIMARY KEY (ID)
);

INSERT INTO APP.Drinks ("Price", "Description")
VALUES
    (2, 'Coca Cola'),
    (3, 'Orange Juice'),
    (4, 'Green Tea'),
    (2, 'Coffee'),
    (3, 'Milk');

CREATE TABLE APP.Starters
(
    ID INTEGER GENERATED ALWAYS AS IDENTITY,
    "Price" INTEGER,
    "Description" VARCHAR(50),
    CONSTRAINT "Starters_pk" PRIMARY KEY (ID)
);

INSERT INTO APP.Starters ("Price", "Description")
VALUES
    (7, 'Garlic bread'),
    (4, 'Tomato soup'),
    (5, 'Mixed salad'),
    (6, 'Potato wedges'),
    (3, 'Breaded mushrooms');

CREATE TABLE APP.alaCarte
(
    ID INTEGER GENERATED ALWAYS AS IDENTITY,
    "Price" INTEGER,
    "Description" VARCHAR(50),
    "Time" INTEGER,
    CONSTRAINT "alaCarte_pk" PRIMARY KEY (ID)
);

INSERT INTO APP.alaCarte ("Price", "Description", "Time")
VALUES
    (15, 'Grilled salmon', 20),
    (12, 'Ribeye steak', 30),
    (9, 'Chicken alfredo', 25),
    (8, 'Vegetable stir-fry', 15),
    (14, 'Seafood paella', 35);

CREATE TABLE orders
(
    ID INTEGER GENERATED ALWAYS AS IDENTITY,
    "alaCarte_ID" INTEGER,
    "Dessert_ID" INTEGER,
    "Drinks_ID" INTEGER,
    "Starters_ID" INTEGER,
    CONSTRAINT "Order_pk" PRIMARY KEY (ID),
    CONSTRAINT "alaCarte_ID" FOREIGN KEY ("alaCarte_ID") REFERENCES APP.alaCarte (ID),
    CONSTRAINT "Dessert_ID" FOREIGN KEY ("Dessert_ID") REFERENCES APP.Dessert (ID),
    CONSTRAINT "Drinks_ID" FOREIGN KEY ("Drinks_ID") REFERENCES APP.Drinks (ID),
    CONSTRAINT "Starters_ID" FOREIGN KEY ("Starters_ID") REFERENCES APP.Starters (ID)
);

INSERT INTO orders ("alaCarte_ID", "Dessert_ID", "Drinks_ID", "Starters_ID")
VALUES
    (1, 2, 3, 4);