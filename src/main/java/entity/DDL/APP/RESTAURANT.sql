create table RESTAURANT
(
    ID        INTEGER default AUTOINCREMENT: start 1 increment 1 generated always as identity
        constraint ID
        primary key,
    NAME      VARCHAR(50),
    TELEPHONE VARCHAR(50)
);

