CREATE TABLE RESERVATION_ROOM
(
     id             varchar(40),
     room_id        varchar(40)  Not null,
     user_id        varchar(40)  Not null,

     CONSTRAINT reservation_room_id PRIMARY KEY (id),
     CONSTRAINT reservation_room_room_id_fk FOREIGN KEY (room_id) references ROOM(id),
     CONSTRAINT reservation_room_user_id_fk FOREIGN KEY (user_id) references USER(id)


);