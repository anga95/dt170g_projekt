create table "Drinks"
(
    ID            INTEGER default AUTOINCREMENT: start 1 increment 1 generated always as identity
        constraint "Drinks_pk"
        primary key,
    "Price"       INTEGER,
    "Description" VARCHAR(50)
);

