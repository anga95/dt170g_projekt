create table "Starters"
(
    ID            INTEGER default AUTOINCREMENT: start 1 increment 1 generated always as identity
        constraint TABLE_NAME_PK
        primary key,
    "Price"       INTEGER,
    "Description" VARCHAR(50)
);

