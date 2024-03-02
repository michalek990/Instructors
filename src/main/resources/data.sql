DELETE FROM addresses;
DELETE FROM cities;
DELETE FROM countries;
DELETE FROM gym_passes;
DELETE FROM instructors;
DELETE FROM messages;
DELETE FROM users;

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
                       (2, 'Marek', 'Tomaszewicz', 'user2', 'marek@gmial.com', '$2a$10$6zSN4QT5wUqyABYGeNyuUO6bqcQWSiqn5SOo6HEp53sx8kRpM7LIm', 'USER', 'true', null);

INSERT INTO instructors (id, first_name, last_name, email, phone_number) VALUES (1, 'Marek', 'Zawada', 'marek@gmail.com', '111111111');
INSERT INTO instructors (id, first_name, last_name, email, phone_number) VALUES (2, 'Tomek', 'Mazur', 'tomek@gmail.com', '222222222');
INSERT INTO instructors (id, first_name, last_name, email, phone_number) VALUES (3, 'Maria', 'Topola', 'maria@gmail.com', '333333333');
INSERT INTO instructors (id, first_name, last_name, email, phone_number) VALUES (4, 'Kazimierz', 'Nowak', 'kazio@gmail.com', '444444444');
INSERT INTO instructors (id, first_name, last_name, email, phone_number) VALUES (5, 'Wacław', 'Wiszniewski', 'waclaw@gmail.com', '555555555');
INSERT INTO instructors (id, first_name, last_name, email, phone_number) VALUES (6, 'Aleksandra', 'Rompa', 'ola@gmail.com', '666666666');
INSERT INTO instructors (id, first_name, last_name, email, phone_number) VALUES (7, 'Helena', 'Cieślak', 'helena@gmail.com', '777777777');
INSERT INTO instructors (id, first_name, last_name, email, phone_number) VALUES (8, 'Jakub', 'Golec', 'jakub@gmail.com', '888888888');
INSERT INTO instructors (id, first_name, last_name, email, phone_number) VALUES (9, 'Błażej', 'Sęk', 'blazi@gmail.com', '999999999');

INSERT INTO addresses (id, street, number, zipcode, city_id, instructor_id) VALUES (1, 'StreetName1', '11', '11-111', 1, 1);
INSERT INTO addresses (id, street, number, zipcode, city_id, instructor_id) VALUES (3, 'StreetName3', '13', '31-111', 3, 2);
INSERT INTO addresses (id, street, number, zipcode, city_id, instructor_id) VALUES (5, 'StreetName5', '15', '51-111', 5, 3);

INSERT INTO gym_passes (id, type, expired_date, price, instructor_id, user_id) VALUES (1, 'Monthly', '2024-02-27', 100.00, 1, 1);
INSERT INTO gym_passes (id, type, expired_date, price, instructor_id, user_id) VALUES (2, 'Weekly', '2024-02-27', 100.00, 2, 1);
INSERT INTO gym_passes (id, type, expired_date, price, instructor_id, user_id) VALUES (3, 'For Seniors', '2024-02-27', 100.00, 3, 2);

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
