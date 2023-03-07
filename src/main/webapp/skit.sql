drop table ORDER_ITEMS;
drop table MENU_ITEMS;
drop table ORDERS;

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


INSERT INTO APP.MENU_ITEMS (PRICE, NAME, DESCRIPTION, TIME, CATEGORY) VALUES
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



SELECT mi.NAME, mi.DESCRIPTION, mi.PRICE, mi.TIME, mi.CATEGORY, o.TABLE_NR, o.ID
FROM MENU_ITEMS mi
         JOIN ORDER_ITEMS oi ON oi.MENU_ITEM_ID = mi.ID
         JOIN ORDERS o ON o.ID = oi.ORDER_ID
WHERE o.TABLE_NR = 1;