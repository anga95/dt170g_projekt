create table MENU.MENU
(
    ID            INTEGER not null
        constraint "MENU_pk"
            primary key,
    NAME          VARCHAR(50),
    RESTAURANT_ID INTEGER
        constraint "MENU_RESTAURANT_ID_fk"
            references RESTAURANT
);

