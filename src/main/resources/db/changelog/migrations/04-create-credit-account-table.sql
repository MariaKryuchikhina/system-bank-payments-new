CREATE TABLE credit_account
(
    id SERIAL PRIMARY KEY,
    number_account character(30),
    expiration_date date,
    type_account character(10),
    interest_rate real,
    accrued_interest real,
    credit_limit bigint,
    current_debt bigint,
    client_id bigint,
    FOREIGN KEY (client_id) REFERENCES client (id) ON DELETE CASCADE
);