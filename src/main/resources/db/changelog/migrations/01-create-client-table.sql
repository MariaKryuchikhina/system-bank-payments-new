CREATE TABLE client(
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    phone_number VARCHAR(30) NOT NULL,
    email VARCHAR(30) NOT NULL
);