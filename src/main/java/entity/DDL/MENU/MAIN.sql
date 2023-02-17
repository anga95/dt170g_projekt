create table MENU.MAIN
(
    ID      INTEGER not null
        constraint "MAIN_pk"
            primary key,
    NAME    INTEGER,
    PRICE   INTEGER,
    MENU_ID INTEGER
        constraint "MAIN_MENU_ID_fk"
            references MENU.MENU
);

