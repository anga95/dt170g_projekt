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


create table APP.ORDERS
(
    ID       INTEGER GENERATED ALWAYS AS IDENTITY
        constraint "ORDERS_pk" primary key,
    TABLE_NR INTEGER
);

CREATE TABLE APP.MENU_ITEMS (
            ID INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
            PRICE INTEGER NOT NULL,
            NAME VARCHAR(100),
            DESCRIPTION VARCHAR(100),
            TIME INTEGER,
            CATEGORY VARCHAR(50) CHECK(CATEGORY IN ('Drinks', 'Dessert', 'Starters', 'MainCourse', 'Lunch'))
);

create table APP.ORDER_ITEMS
(
    ID           INTEGER GENERATED ALWAYS AS IDENTITY
        constraint "ORDER_ITEMS_pk" primary key,
    ORDER_ID     INTEGER
        constraint ORDER_ID references ORDERS,
    MENU_ITEM_ID INTEGER
        constraint MENU_ITEM_ID references MENU_ITEMS,
    STATUS       BOOLEAN default FALSE
);


INSERT INTO APP.ORDERS (TABLE_NR)
VALUES (1), (2), (3);


INSERT INTO APP.MENU_ITEMS (PRICE, NAME, DESCRIPTION, TIME, CATEGORY)
VALUES
      (30, 'French fries', 'Crispy fries with classic ketchup', 10, 'Starters'),
      (40, 'Grilled asparagus', 'Tender asparagus with a zesty lemon butter', 15, 'Starters'),
      (20, 'Mashed potatoes', 'Smooth and buttery mashed potatoes', 15, 'Starters'),
      (100, 'Chicken', 'Juicy chicken with a side of vegetables', 30, 'MainCourse'),
      (80, 'Spaghetti', 'Traditional pasta dish with rich tomato sauce', 25, 'MainCourse'),
      (120, 'Tenderloin steak', 'Tender steak with creamy mushroom sauce', 35, 'MainCourse'),
      (40, 'Chocolate chip cookie', 'Classic cookie with melty chocolate chips', 10, 'Dessert'),
      (60, 'Vanilla ice cream', 'Rich and creamy vanilla ice cream', 10, 'Dessert'),
      (30, 'Soda', 'Refreshing soda with unlimited refills', 5, 'Drinks'),
      (40, 'Orange juice', 'Fresh and tangy orange juice', 10, 'Drinks'),
      (50, 'Beer', 'Cold and refreshing beer', 15, 'Drinks'),
      (60, 'Red wine', 'Rich and bold red wine', 20, 'Drinks'),
      (70, 'White wine', 'Crisp and refreshing white wine', 20, 'Drinks'),
      (80, 'Margarita', 'Classic tequila cocktail with a salted rim', 10, 'Drinks'),
      (50, 'Caesar salad', 'Fresh greens and tender chicken in a tangy dressing', 15, 'Lunch'),
      (70, 'Mixed greens', 'Light and refreshing salad with a balsamic twist', 10, 'Lunch'),
      (100, 'Club sandwich', 'Hearty sandwich with turkey, bacon, and all the fixings', 20, 'Lunch'),
      (90, 'Cheeseburger', 'Juicy burger with melty cheese and crispy fries', 15, 'Lunch'),
      (60, 'Margherita pizza', 'Traditional pizza with fresh mozzarella and tomato sauce', 25, 'Lunch'),
      (30, 'Tomato soup', 'Comforting soup with crunchy croutons', 10, 'Starters');


INSERT INTO APP.ORDER_ITEMS (ORDER_ID, MENU_ITEM_ID)
VALUES
    (1, 1),
    (1, 3),
    (1, 6),
    (2, 2),
    (2, 5),
    (2, 9),
    (3, 4),
    (3, 7),
    (3, 10);

