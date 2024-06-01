CREATE TABLE ROOM
(
    id             varchar(100),
    beds_number    varchar(100)  Not null,
    wifi           varchar(100)   Not null,
    room_view      varchar(100)   Not null,
    room_service   varchar(100)   Not null,
    price          varchar(100) Not null,
    ac             varchar(100)   Not null,
    CONSTRAINT room_id_pk PRIMARY KEY (id)

);

