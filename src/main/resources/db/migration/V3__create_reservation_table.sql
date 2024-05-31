CREATE TABLE RESERVATION
(
     id                  varchar(40),
     user_id             varchar(40)  Not null,
     room_id             varchar(40)  Not null,
     check_in            timestamp  Not null,
     check_out           timestamp  Not null,
     guests_number       varchar(10)  Not null,
     payed               varchar(1)  Not null,
     type                varchar(40)  Not null,
     status              varchar(40)  Not null,

     CONSTRAINT reservation_room_id PRIMARY KEY (id),
     CONSTRAINT reservation_room_id_fk FOREIGN KEY (room_id) references ROOM(id),
     CONSTRAINT reservation_user_id_fk FOREIGN KEY (user_id) references USER(id)


);