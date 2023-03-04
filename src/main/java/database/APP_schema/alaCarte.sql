create table "alaCarte"
(
    ID            INTEGER default AUTOINCREMENT: start 1 increment 1 generated always as identity
        constraint "alaCarte_pk"
        primary key,
    "Price"       INTEGER,
    "Description" VARCHAR(50),
    "Time"        INTEGER
);

