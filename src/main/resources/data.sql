INSERT INTO products (id, name, price) VALUES ('1', 'Produkt 1', 19.99);
INSERT INTO products (id, name, price) VALUES ('2', 'Produkt 2', 29.99);
INSERT INTO products (id, name, price) VALUES ('3', 'Produkt 3', 39.99);
INSERT INTO products (id, name, price) VALUES ('4', 'Produkt 4', 49.99);

INSERT INTO countries (id, name) VALUES (1, 'Hiszapnia');
INSERT INTO countries (id, name) VALUES (2, 'Francja');
INSERT INTO countries (id, name) VALUES (3, 'Polska');
INSERT INTO countries (id, name) VALUES (4, 'Niemcy');
INSERT INTO countries (id, name) VALUES (5, 'Portugalia');

INSERT INTO cities (id, name, country_id) VALUES (1,'Madryt', 1);
INSERT INTO cities (id, name, country_id) VALUES (2,'Paryż', 2);
INSERT INTO cities (id, name, country_id) VALUES (3,'Warszawa', 3);
INSERT INTO cities (id, name, country_id) VALUES (4,'Berlin', 4);
INSERT INTO cities (id, name, country_id) VALUES (5,'Lizbona', 5);

INSERT INTO users (id, firstname, lastname, username, email, password, roles, is_active, verification_code)
                VALUES (1, 'Michal', 'Kowal', 'user1', 'michalek@gmial.com', '$2a$10$vtVp3J/LlPQ6U/p3QLvFw.8r3/5CgKfUTHh0C0BJj9sT/5JfLqTWC', 'ADMIN', 'true', null),
                       (2, 'Marek', 'Tomaszewicz', 'user2', 'marek@gmial.com', '$2a$10$6zSN4QT5wUqyABYGeNyuUO6bqcQWSiqn5SOo6HEp53sx8kRpM7LIm', 'INSTRUCTOR', 'true', null),
                       (3, 'Marek', 'Zawada','user3', 'marek2@gmail.com', '$2a$10$lGHDSwBq8bNayguc4Mp9Kui2ndrdb5rMdQvBze1f40G9dswJVA6IG', 'INSTRUCTOR', 'true', null),
                       (4, 'Tomek', 'Mazur','user4', 'tomek@gmail.com', '$2a$10$4A2pz2NuoAXVJBJ3jNV8Xu56jiX/o.0vUnbSZmx/tFmzVpNhAacra', 'USER', 'true', null),
                       (5, 'Maria', 'Topola','user5', 'maria@gmail.com', '$2a$10$EIZQ7yFirOqBpYSg/r4u3uY9yyTlQRG97resFLPqhkNk4O5zf7A.W', 'USER', 'true', null),
                       (6, 'Kazimierz', 'Nowak','user6', 'kazio@gmail.com', '$2a$10$qM7cnRGWq4cfSpje9uYN5eRqsbafOw2h5Z1.731Kq.MTsoqySiXCi', 'USER', 'true', null),
                       (7, 'Wacław', 'Wiszniewski','user7', 'waclaw@gmail.com', '$2a$10$LLb7Q3sZDnY2jFiHvYnTcepnwFv7l1qRoDqEgSwlO5ThYJVxjxrZu', 'USER', 'true', null),
                       (8, 'Aleksandra', 'Rompa','user8', 'ola@gmail.com', '$2a$10$3cBvipiCT3D2muWslEulMep1yBkAFGNdigS76PM4fCPj3tnooaazC', 'USER', 'true', null),
                       (9, 'Helena', 'Cieślak','user9', 'helena@gmail.com', '$2a$10$tzMbUYNLMOV.UhmPve/wLuK/E2leUqptDOlbDp1t41sge22Z2QF2O', 'USER', 'true', null),
                       (10, 'Jakub', 'Golec','user0', 'jakub@gmail.com', '$2a$10$35YTjnCVI7BVJn83IGkIhO8gkuOpUVRXC0Hxq.UMAhUzLsp8Ds5Xm', 'USER', 'true', null);

INSERT INTO activities (id, name, description, date, number_of_participants, instructor_id) VALUES
         (1,'Yoga Class', 'A relaxing yoga session', '2023-04-01 10:00:00', 4, 2),
         (2,'HIIT Workout', 'High-intensity interval training', '2023-04-02 08:00:00', 15, 2),
         (3,'Swimming Lessons', 'Learn to swim or improve your technique', '2023-04-03 09:00:00', 10, 3),
         (4,'Cycling Marathon', 'Join our long-distance cycling event', '2023-04-04 07:00:00', 30, 3),
         (5,'Pilates Class', 'Improve your strength and flexibility', '2023-04-05 11:00:00', 25, 2);

INSERT INTO activity_participants (activity_id, user_id) VALUES
        (1, 6),
        (1, 7),
        (1, 8),
        (2, 9),
        (2, 10),
        (3, 10);

INSERT INTO addresses (id,street, number, zipcode, latitude, longitude, city_id) VALUES (1,'Main Street', '123', '00000', '40.712776', '-74.005974', 1);
INSERT INTO addresses (id,street, number, zipcode, latitude, longitude, city_id) VALUES (2,'Second Street', '456', '11111', '34.052235', '-118.243683', 2);
INSERT INTO addresses (id,street, number, zipcode, latitude, longitude, city_id) VALUES (3,'Third Street', '789', '22222', '41.878113', '-87.629799', 3);
INSERT INTO addresses (id,street, number, zipcode, latitude, longitude, city_id) VALUES (4,'Fourth Street', '101', '33333', '51.507351', '-0.127758', 4);
INSERT INTO addresses (id,street, number, zipcode, latitude, longitude, city_id) VALUES (5,'Fifth Street', '202', '44444', '48.856613', '2.352222', 5);
INSERT INTO addresses (id,street, number, zipcode, latitude, longitude, city_id) VALUES (6,'Sixth Street', '303', '55555', '38.722252', '-9.139337', 2);
INSERT INTO addresses (id,street, number, zipcode, latitude, longitude, city_id) VALUES (7,'Seventh Street', '404', '66666', '52.520007', '13.404954', 3);
INSERT INTO addresses (id,street, number, zipcode, latitude, longitude, city_id) VALUES (8,'Eighth Street', '505', '77777', '52.229676', '21.012229', 4);
INSERT INTO addresses (id,street, number, zipcode, latitude, longitude, city_id) VALUES (9,'Ninth Street', '606', '88888', '52.406374', '16.925168', 5);
INSERT INTO addresses (id,street, number, zipcode, latitude, longitude, city_id) VALUES (10,'Tenth Street', '707', '99999', '37.774929', '-122.419416', 1);

INSERT INTO gyms (id,name, phone_number, email, description, day_of_week, open_hour, close_hour, address_id) VALUES
        (1,'Gym A', '123-456-7890', 'contact@gyma.com', 'Full-service fitness center', 'MONDAY_TO_FRIDAY', '06:00', '22:00', 1),
        (2,'Gym B', '123-456-7891', 'contact@gymb.com', 'Community fitness hub', 'MONDAY_TO_FRIDAY', '05:00', '23:00', 2),
        (3,'Gym C', '123-456-7892', 'contact@gymc.com', 'Elite athletic training facility', 'MONDAY_TO_FRIDAY', '06:00', '21:00', 3),
        (4,'Gym D', '123-456-7893', 'contact@gymd.com', 'High-energy group classes', 'MONDAY_TO_SUNDAY', '07:00', '20:00', 4),
        (5,'Gym E', '123-456-7894', 'contact@gyms.com', 'Yoga and wellness studio', 'MONDAY_TO_SUNDAY', '06:00', '22:00', 5),
        (6,'Gym F', '123-456-7895', 'contact@gymf.com', 'State-of-the-art weightlifting gym', 'MONDAY_TO_SUNDAY', '08:00', '18:00', 6),
        (7,'Gym G', '123-456-7896', 'contact@gymg.com', 'Indoor cycling and spin studio', 'WEEKEND', '09:00', '15:00', 7),
        (8,'Gym H', '123-456-7897', 'contact@gymh.com', 'Modern Pilates studio', 'MONDAY_TO_SUNDAY', '06:00', '21:00', 8),
        (9,'Gym I', '123-456-7898', 'contact@gymi.com', 'Martial arts and boxing gym', 'MONDAY_TO_SUNDAY', '07:00', '22:00', 9),
        (10,'Gym J', '123-456-7899', 'contact@gymj.com', 'Outdoor and adventure sports training', 'MONDAY_TO_FRIDAY', '06:00', '20:00', 10);


INSERT INTO invoices (id, amount, invoice_date, invoice_number, customer_id) VALUES (1, 300.00, '2024-02-27', 1, 3);

INSERT INTO gym_passes (id, type, expired_date, price, invoice_id, user_id) VALUES (1, 'Monthly', '2024-02-27', 100.00, 1, 3);
INSERT INTO gym_passes (id, type, expired_date, price, invoice_id, user_id) VALUES (2, 'Weekly', '2024-02-27', 100.00, 1, 3);
INSERT INTO gym_passes (id, type, expired_date, price, invoice_id, user_id) VALUES (3, 'For Seniors', '2024-02-27', 100.00, 1, 3);

INSERT INTO messages (content, timestamp, user_id) VALUES ('Hello, how are you?', '2024-02-27 14:35:50', 1);
INSERT INTO messages (content, timestamp, user_id) VALUES ('This is a sample message.', '2024-02-28 09:15:00', 1);
INSERT INTO messages (content, timestamp, user_id) VALUES ('Remember the meeting at 10am tomorrow.', '2024-03-01 16:45:30', 1);
INSERT INTO messages (content, timestamp, user_id) VALUES ('Lunch at noon?', '2024-03-02 11:00:00', 2);
INSERT INTO messages (content, timestamp, user_id) VALUES ('Project deadline extended to next week.', '2024-03-03 18:30:45', 2);
INSERT INTO messages (content, timestamp, user_id) VALUES ('Can we discuss the report tomorrow?', '2024-03-04 10:20:30', 1);
INSERT INTO messages (content, timestamp, user_id) VALUES ('Great job on the presentation today!', '2024-03-05 15:45:00', 2);
INSERT INTO messages (content, timestamp, user_id) VALUES ('Could you send me the files by Friday?', '2024-03-06 09:30:15', 2);
INSERT INTO messages (content, timestamp, user_id) VALUES ('Thank you for your help with the project.', '2024-03-07 17:00:00', 1);
INSERT INTO messages (content, timestamp, user_id) VALUES ('Meeting confirmed for next Wednesday at 3pm.', '2024-03-08 12:15:45', 1);
INSERT INTO messages (content, timestamp, user_id) VALUES ('Reminder: Yearly review meeting next Friday.', '2024-03-09 08:30:00', 2);
INSERT INTO messages (content, timestamp, user_id) VALUES ('Urgent: Server downtime scheduled for maintenance tonight.', '2024-03-10 14:00:00', 1);
INSERT INTO messages (content, timestamp, user_id) VALUES ('Updated project timeline has been shared in the drive.', '2024-03-11 16:45:30', 2);
INSERT INTO messages (content, timestamp, user_id) VALUES ('Client feedback received and noted.', '2024-03-11 16:45:30', 2);
