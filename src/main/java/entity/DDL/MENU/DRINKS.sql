create table MENU.DRINKS
(
    ID      INTEGER not null
        constraint "DRINKS_pk"
            primary key,
    NAME    VARCHAR(50),
    PRICE   VARCHAR(50),
    MENU_ID INTEGER
        constraint "DRINKS_MENU_ID_fk"
            references MENU.MENU
);

