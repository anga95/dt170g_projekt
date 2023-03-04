create table "Order"
(
    ID            INTEGER default AUTOINCREMENT: start 1 increment 1 generated always as identity
        constraint "Order_pk"
        primary key,
    "alaCarte_ID" INTEGER
        constraint "alaCarte_ID"
            references "alaCarte",
    "Dessert_ID"  INTEGER
        constraint "Dessert_ID"
            references "Dessert",
    "Drinks_ID"   INTEGER
        constraint "Drinks_ID"
            references "Drinks",
    "Starters_ID" INTEGER
        constraint "Starters_ID"
            references "Starters"
);

