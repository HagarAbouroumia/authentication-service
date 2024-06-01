CREATE TABLE USER(
    id varchar(100),
    full_name varchar(100) Not null,
    mail varchar(100) Not null,
    mobile_number varchar(100) Not null,
    password varchar(100) Not null,
    birth_date varchar(100) Not null,

     CONSTRAINT user_id PRIMARY KEY (id)
);