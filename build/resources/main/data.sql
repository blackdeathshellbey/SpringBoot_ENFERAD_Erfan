INSERT INTO ROOM(id, name, level, current_temperature, target_temperature)
VALUES (1, 'Room1', 1, 13.1, 19.1);
INSERT INTO ROOM(id, name, level, current_temperature, target_temperature)
VALUES (2, 'Room2', 2, 12.8, 19.1);
INSERT INTO ROOM(id, name, level, current_temperature, target_temperature)
VALUES (3, 'Room3', 3, 15.7, 19.6);
INSERT INTO ROOM(id, name, level, current_temperature, target_temperature)
VALUES (4, 'Room4', 3, 13.2, 19.7);

INSERT INTO HEATER(id, heater_status, name, power, room_id)
VALUES (1, 'ON', 'Heater1', 1500, 1);
INSERT INTO HEATER(id, heater_status, name, power, room_id)
VALUES (2, 'ON', 'Heater2', 1000, 1);

INSERT INTO RWINDOW(id, status, name, room_id)
VALUES (1, 'OPEN', 'Window 1', 1);
INSERT INTO RWINDOW(id, status, name, room_id)
VALUES (2, 'OPEN', 'Window 2', 3);
INSERT INTO RWINDOW(id, status, name, room_id)
VALUES (3, 'OPEN', 'Window 2', 2);
INSERT INTO RWINDOW(id, status, name, room_id)
VALUES (4, 'OPEN', 'Window 3', 1);
INSERT INTO RWINDOW(id, status, name, room_id)
VALUES (5, 'OPEN', 'Window 4', 2);
INSERT INTO RWINDOW(id, status, name, room_id)
VALUES (6, 'CLOSED', 'Window 5', 3);
INSERT INTO RWINDOW(id, status, name, room_id)
VALUES (7, 'CLOSED', 'Window 6', 1);
INSERT INTO RWINDOW(id, status, name, room_id)
VALUES (8, 'CLOSED', 'Window 7', 1);
INSERT INTO RWINDOW(id, status, name, room_id)
VALUES (9, 'CLOSED', 'Window 8', 1);

INSERT INTO BUILDING(id, name, city,zip_code)
VALUES (1, 'Ecole Des Mines', 'Saint Etienne',42000);
INSERT INTO BUILDING(id, name, city,zip_code)
VALUES (2, 'Ecole Des Mines, Espace Furier', 'Saint Etienne',42000);



