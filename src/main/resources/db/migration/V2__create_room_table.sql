CREATE TABLE ROOM
(
     id             varchar(40),
     beds_number    varchar(10)  Not null,
     persons_number varchar(10)  Not null,
     wifi           varchar(1)   Not null,
     tv             varchar(1)   Not null,
     room_view      varchar(1)   Not null,
     room_service   varchar(1)   Not null,
     price          varchar(100) Not null,
     ac             varchar(1)   Not null,

     CONSTRAINT room_id_pk PRIMARY KEY (id)

);