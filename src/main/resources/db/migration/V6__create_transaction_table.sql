CREATE TABLE TRANSACTIONS
(
    id           varchar(100),
    card_number  varchar(100) Not null,
    expiry_date  varchar(100) Not null,
    cvv          varchar(100) Not null,
    name_on_card varchar(100) Not null,

        CONSTRAINT transaction_id PRIMARY KEY (id)
);