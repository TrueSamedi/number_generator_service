CREATE TABLE numbers (
    id bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY UNIQUE,
    number varchar(64) UNIQUE NOT NULL
);