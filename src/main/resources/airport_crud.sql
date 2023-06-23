# 10 INSERTION STATEMENTS (FOR EACH TABLE)
INSERT INTO airlines VALUES (1, "American Airlines Inc.", "AAL");
INSERT INTO airlines VALUES (14, "Air Canada", "ACA");
INSERT INTO airlines VALUES (20, "Lufthansa Cargo Ag.", "DLH");
INSERT INTO airlines VALUES (43, "Hong Kong Dragon Airlines Limited", "HAD");
INSERT INTO airlines VALUES (131, "Japan Airlines Co. Ltd.", "JAL");
INSERT INTO airlines VALUES (81, "Quantas Airways Ltd.", "QFA");
INSERT INTO airlines VALUES (77, "Egyptair", "MSR");
INSERT INTO airlines VALUES (65, "Jazeera Airways", "JZR");
INSERT INTO airlines VALUES (9, "Khazar", "---");
INSERT INTO airlines VALUES (30, "Libyan Wings.", "LWA");

INSERT INTO airplane_types VALUES (1, "Airbus", "A320");
INSERT INTO airplane_types VALUES (2, "Bloop", "B738");
INSERT INTO airplane_types VALUES (3, "Airbus", "A321");
INSERT INTO airplane_types VALUES (4, "Airbus", "A319");
INSERT INTO airplane_types VALUES (5, "Bloop", "B77W");
INSERT INTO airplane_types VALUES (6, "Bloop", "B737");
INSERT INTO airplane_types VALUES (7, "Bloop", "B772");
INSERT INTO airplane_types VALUES (8, "Embraer", "E170");
INSERT INTO airplane_types VALUES (9, "Cessna", "C172");
INSERT INTO airplane_types VALUES (10, "ATR", "AT75");

INSERT INTO airplanes VALUES (1, 1, 50, 1);
INSERT INTO airplanes VALUES (2, 131, 50, 1);
INSERT INTO airplanes VALUES (3, 81, 50, 7);
INSERT INTO airplanes VALUES (4, 14, 50, 8);
INSERT INTO airplanes VALUES (5, 20, 50, 6);
INSERT INTO airplanes VALUES (6, 1, 0, 3);
INSERT INTO airplanes VALUES (7, 30, 0, 3);
INSERT INTO airplanes VALUES (8, 1, 0, 5);
INSERT INTO airplanes VALUES (9, 77, 0, 7);
INSERT INTO airplanes VALUES (10, 43, 0, 2);

INSERT INTO countries VALUES (1, "United States", "USA");
INSERT INTO countries VALUES (45, "Denmark", "DNK");
INSERT INTO countries VALUES (20, "Egypt", "EGY");
INSERT INTO countries VALUES (375, "Belarus", "BLR");
INSERT INTO countries VALUES (44, "United Kingdom", "GBR");
INSERT INTO countries VALUES (248, "Seychelles", "SYC");
INSERT INTO countries VALUES (66, "Thailand", "THA");
INSERT INTO countries VALUES (974, "Qatar", "QAT");
INSERT INTO countries VALUES (52, "Mexico", "MEX");
INSERT INTO countries VALUES (81, "Japan", "JPN");

INSERT INTO airports VALUES (1, "John F. Kennedy Airport", "JFK", 1, 40.6434, -73.7890);
INSERT INTO airports VALUES (2, "Copenhagen Airport", "CPH", 45, 55.6121, 12.6477);
INSERT INTO airports VALUES (3, "Cairo International Airport", "CAI", 20, 30.1119, 31.4007);
INSERT INTO airports VALUES (4, "Minsk National Airport", "MSQ", 375, 53.8897, 28.0342);
INSERT INTO airports VALUES (5, "London Gatwick Airport", "LGW", 44, 51.1537, -0.1821);
INSERT INTO airports VALUES (6, "Seychelles International Airport", "SEZ", 248, -4.6709, 55.5115);
INSERT INTO airports VALUES (7, "Suvarnabhumi Airport", "BKK", 66, 13.6918, 100.7500);
INSERT INTO airports VALUES (8, "Hamad International Airport", "DOH", 974, 25.2598, 51.6143);
INSERT INTO airports VALUES (9, "Felipe Angeles International Airport", "NLU", 52, 19.7353, -99.0265);
INSERT INTO airports VALUES (10, "Naha Airport", "OKA", 81, 24.2064, 127.6465);

INSERT INTO licenses VALUES (1, 12345678, "1999-09-01", "2019-09-22", 1);
INSERT INTO licenses VALUES (2, 87654321, "1992-04-17", "2026-09-11", 2);
INSERT INTO licenses VALUES (3, 32987127, "1995-04-05", "2029-09-19", 3);
INSERT INTO licenses VALUES (4, 51215151, "2019-07-23", "2022-10-01", 4);
INSERT INTO licenses VALUES (5, 91823791, "1990-01-15", "2023-01-17", 5);
INSERT INTO licenses VALUES (6, 90347678, "2021-11-05", "2024-02-25", 6);
INSERT INTO licenses VALUES (7, 76213543, "2003-08-08", "2025-03-29", 7);
INSERT INTO licenses VALUES (8, 42783142, "1996-09-19", "2026-07-04", 8);
INSERT INTO licenses VALUES (9, 52167430, "1998-08-27", "2027-06-05", 9);
INSERT INTO licenses VALUES (10, 69128341, "1996-12-25", "2026-08-15", 10);

INSERT INTO employees VALUES (1, "Alejandro", "Saab", 1);
INSERT INTO employees VALUES (2, "Yae", "Miko", 2);
INSERT INTO employees VALUES (4, "Ai", "Hoshino", 4);
INSERT INTO employees VALUES (3, "Miles", "Morales", 3);
INSERT INTO employees VALUES (6, "Marinette", "Dupen-Chang", 6);
INSERT INTO employees VALUES (5, "Jack", "Edwards", 5);
INSERT INTO employees VALUES (7, "Kaeya", "Alberich", 7);
INSERT INTO employees VALUES (8, "Gwen", "Stacy", 8);
INSERT INTO employees VALUES (9, "Harry", "Potter", 9);
INSERT INTO employees VALUES (10, "Putri", "Ariani", 10);

INSERT INTO routes VALUES (1, 1, 2, "12:30:00", "01:25:00");
INSERT INTO routes VALUES (2, 3, 4, "10:30:00", "02:25:00");
INSERT INTO routes VALUES (3, 5, 6, "19:18:00", "22:45:00");
INSERT INTO routes VALUES (4, 7, 8, "13:30:00", "23:30:00");
INSERT INTO routes VALUES (5, 9, 10, "01:10:00", "04:30:00");
INSERT INTO routes VALUES (6, 3, 6, "15:30:00", "19:25:00");
INSERT INTO routes VALUES (7, 4, 5, "20:30:00", "05:45:00");
INSERT INTO routes VALUES (8, 10, 1, "19:30:00", "23:30:00");
INSERT INTO routes VALUES (9, 9, 2, "18:10:00", "09:07:00");
INSERT INTO routes VALUES (10, 7, 6, "14:30:00", "18:25:00");

INSERT INTO flights VALUES (1, 1, 1, "2023-07-28", "STANDBY");
INSERT INTO flights VALUES (2, 2, 2, "2023-10-31", "DELAYED");
INSERT INTO flights VALUES (3, 3, 3, "2023-08-10", "STANDBY");
INSERT INTO flights VALUES (4, 4, 4, "2023-09-01", "SCHEDULED");
INSERT INTO flights VALUES (5, 5, 5, "2023-06-25", "DELAYED");
INSERT INTO flights VALUES (6, 6, 6, "2023-12-25", "DELAYED");
INSERT INTO flights VALUES (7, 7, 7, "2023-07-28", "STANDBY");
INSERT INTO flights VALUES (8, 8, 8, "2023-08-14", "DELAYED");
INSERT INTO flights VALUES (9, 9, 9, "2023-12-15", "STANDBY");
INSERT INTO flights VALUES (10, 10, 10, "2023-09-17", "SCHEDULED");

INSERT INTO packages VALUES (123, "Raiden Ei", "9680 Lakewood Ave.", 6);
INSERT INTO packages VALUES (234, "Gretchen Miller", "692C E. St Paul St.", 6);
INSERT INTO packages VALUES (345, "Skyler White", "217 Sugar Dr.", 7);
INSERT INTO packages VALUES (456, "Saul Goodman", "62 Pumpkin Hill Ave.", 7);
INSERT INTO packages VALUES (567, "Suleiman Khankar", "8245 Stonybrook Ave.", 8);
INSERT INTO packages VALUES (678, "Betty White", "207 Corona Street", 8);
INSERT INTO packages VALUES (789, "Kiku Honda", "8417 St Margarets Drive", 9);
INSERT INTO packages VALUES (890, "Ivan Braginsky", "65 Grove Drive", 9);
INSERT INTO packages VALUES (124, "ALfred F. Jones", "8131 Lake Forest Court", 10);
INSERT INTO packages VALUES (168, "Lovino Vargas", "38 Piper Lane", 10);

INSERT INTO reservations VALUE (1, 1, "A35", 8000);
INSERT INTO reservations VALUE (2, 1, "G44", 1600);
INSERT INTO reservations VALUE (3, 2, "H12", 3423);
INSERT INTO reservations VALUE (4, 2, "B01", 1239);
INSERT INTO reservations VALUE (5, 3, "B02", 8934);
INSERT INTO reservations VALUE (6, 3, "C33", 5674);
INSERT INTO reservations VALUE (7, 4, "D50", 3240);
INSERT INTO reservations VALUE (8, 4, "F24", 1245);
INSERT INTO reservations VALUE (9, 6, "F25", 9323);
INSERT INTO reservations VALUE (10, 6, "E07", 2678);

INSERT INTO passengers VALUE (1, "Pippi", "Longstocking", 20803264, 1);
INSERT INTO passengers VALUE (2, "Mathilda", "Harris", 18317378, 2);
INSERT INTO passengers VALUE (3, "Abbie", "Rose", 74533087, 3);
INSERT INTO passengers VALUE (4, "Rita", "Hendrix", 81070603, 4);
INSERT INTO passengers VALUE (5, "Louisa", "Calhoun", 21441438, 5);
INSERT INTO passengers VALUE (6, "Terry", "Spence", 49917832, 6);
INSERT INTO passengers VALUE (7, "Liam", "Tate", 98636931, 7);
INSERT INTO passengers VALUE (8, "Laura", "Roberson", 55590121, 8);
INSERT INTO passengers VALUE (9, "Lorcan", "Petty", 75025637, 9);
INSERT INTO passengers VALUE (10, "Sara", "Copeland", 59544818, 10);

# 5 ALTER TABLE STATEMENTS
ALTER TABLE employees ADD COLUMN gender ENUM('M','F','X') AFTER last_name;
ALTER TABLE employees DROP COLUMN gender;
ALTER TABLE employees ADD COLUMN address VARCHAR(45);
ALTER TABLE employees DROP COLUMN address;
ALTER TABLE countries ADD COLUMN capital VARCHAR(45);
ALTER TABLE countries DROP COLUMN capital;

# 10 UPDATE STATEMENTS
UPDATE passengers SET first_name = "Hannah" WHERE first_name = "Abbie";
UPDATE flights SET status = "SCHEDULED" WHERE status = "STANDBY";
UPDATE reservations SET flight_id = 5 WHERE id > 8;
UPDATE packages SET name = "Jack Frost" WHERE id = 456;
UPDATE employees SET first_name = "Hermione", last_name = "Granger" WHERE first_name = "Harry";
UPDATE employees SET gender = "F" WHERE (id % 2) = 0;
UPDATE employees SET gender = "M" WHERE (id % 2) > 0;
UPDATE countries SET code = "KHR" WHERE name = "Khazar";
UPDATE airplane_types SET brand = "Boeing" WHERE brand = "Bloop";
UPDATE reservations SET price = price * (1.05);

# 10 DELETION STATEMENTS
DELETE FROM packages WHERE id < 200;
DELETE FROM passengers WHERE LEFT(first_name, 1) = 'L';
DELETE FROM reservations WHERE id NOT IN (SELECT reservation_id FROM passengers);
DELETE FROM flights WHERE status = "DELAYED";
DELETE FROM routes WHERE from_airport = 8 OR to_airport = 8 OR from_airport = 9 OR to_airport = 9;
DELETE FROM flights WHERE route_id NOT IN (SELECT id FROM routes);
DELETE FROM airports WHERE id = 8 or id = 9;
DELETE FROM countries WHERE id NOT IN (SELECT country FROM airports);
DELETE FROM airlines WHERE id NOT IN (SELECT airline_id FROM airplanes);
DELETE FROM airplane_types WHERE id NOT IN (SELECT type_id FROM airplanes);

# 1 BIG JOIN STATEMENT FOR ALL TABLES
SELECT * from airports
   JOIN countries ON (countries.id = airports.country)
   JOIN routes ON (routes.from_airport = airports.id)
   JOIN flights ON (flights.route_id = routes.id)
   JOIN reservations ON (reservations.flight_id = flights.id)
   JOIN passengers ON (passengers.reservation_id = reservations.id)
   JOIN airplanes ON (airplanes.id = flights.airplane_id)
   JOIN packages ON (packages.airplane_id = airplanes.id)
   JOIN employees ON (employees.airplane_id = airplanes.id)
   JOIN licenses ON (licenses.id = employees.id)
   JOIN airplane_types ON (airplane_types.id = airplanes.type_id)
   JOIN airlines ON (airlines.id = airplanes.airline_id);

# 5 STATEMENTS WITH LEFT, RIGHT, INNER, OUTER JOINS
SELECT * FROM passengers LEFT JOIN reservations ON passengers.reservation_id = reservations.id;
SELECT * FROM airplanes RIGHT JOIN airlines ON airplanes.airline_id = airlines.id;
SELECT * FROM employees INNER JOIN flights ON employees.airplane_id = flights.airplane_id;
SELECT * FROM airports LEFT OUTER JOIN countries ON airports.country = countries.id;
SELECT * FROM employees RIGHT OUTER JOIN licenses ON employees.id = licenses.id;

# 7 STATEMENTS W/ AGGREGATE FUNCTIONS, GROUP BY, AND WITHOUT HAVING
SELECT last_name, COUNT(last_name) FROM employees GROUP BY last_name;
SELECT flight_id, MAX(price) FROM reservations GROUP BY flight_id;
SELECT SUM(price) FROM reservations;
SELECT AVG(price) FROM reservations;
SELECT MAX(price) FROM reservations;
SELECT MIN(price) FROM reservations;
SELECT status, COUNT(status) FROM flights GROUP BY status;

# 7 STATEMENTS W/ AGGREGATE FUNCTIONS, GROUP BY, AND WITH HAVING
SELECT last_name, COUNT(last_name) FROM employees GROUP BY last_name HAVING LEFT(last_name, 1) >= "M" ORDER BY last_name ASC;
SELECT capacity, COUNT(capacity) FROM airplanes GROUP BY capacity HAVING capacity = 0;
SELECT date, COUNT(date) FROM flights GROUP BY date HAVING MONTH(date) >= "07" ORDER BY date ASC;
SELECT longitude FROM airports GROUP BY longitude HAVING longitude > 0 ORDER BY longitude ASC;
SELECT latitude FROM airports GROUP BY latitude HAVING latitude < 0 ORDER BY latitude ASC;
SELECT brand, COUNT(brand) FROM airplane_types GROUP BY brand HAVING LEFT(brand, 1) <= 'C';
SELECT flight_id FROM reservations GROUP BY flight_id HAVING flight_id <= 3;