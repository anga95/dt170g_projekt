create table MENU.DESSERT
(
    NAME    VARCHAR(50),
    PRICE   INTEGER,
    ID      INTEGER not null
        constraint "DESSERT_pk"
            primary key,
    MENU_ID INTEGER
        constraint "DESSERT_MENU_ID_fk"
            references MENU.MENU
);

