create table MENU.STARTER
(
    ID      INTEGER not null
        constraint "STARTER_pk"
            primary key,
    NAME    VARCHAR(50),
    PRICE   INTEGER,
    MENU_ID INTEGER
        constraint "STARTER_MENU_ID_fk"
            references MENU.MENU
);

