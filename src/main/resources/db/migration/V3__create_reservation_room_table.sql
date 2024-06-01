CREATE TABLE RESERVATION_ROOM
(
     id             varchar(100),
     room_id        varchar(100)  Not null,
     mail        varchar(100)  Not null,
     full_name        varchar(100)  Not null,
     mobile_number        varchar(100)  Not null,
     user_id        varchar(100)  Not null,

     CONSTRAINT reservation_room_id PRIMARY KEY (id)


);