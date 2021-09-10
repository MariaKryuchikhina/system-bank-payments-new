CREATE TABLE main_account
(
    id SERIAL PRIMARY KEY,
    number_account character(30),
    expiration_date date,
    type_account character(10),
    amount bigint,
    client_id bigint,
    FOREIGN KEY (client_id) REFERENCES client (id) ON DELETE CASCADE
);