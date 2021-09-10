CREATE TABLE deposit_account
(
    id SERIAL PRIMARY KEY,
    number_account character(30),
    expiration_date date,
    type_account character(10),
    amount bigint,
    interest_rate real,
    client_id bigint,
    FOREIGN KEY (client_id) REFERENCES client (id) ON DELETE CASCADE
);