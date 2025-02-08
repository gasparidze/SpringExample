--liquibase formatted sql

--changeset springex:1
CREATE SCHEMA spring_schema;

--changeset springex:2
CREATE TABLE IF NOT EXISTS spring_schema.client(
    id SERIAL PRIMARY KEY ,
    fio VARCHAR(50) NOT NULL ,
    birth_date DATE NOT NULL ,
    phone VARCHAR(50) NOT NULL ,
    email VARCHAR(100) NOT NULL
);

--changeset springex:3
CREATE TABLE IF NOT EXISTS spring_schema.client_account(
    id SERIAL PRIMARY KEY ,
    balance NUMERIC NOT NULL CHECK (balance > 0),
    client_id INT NOT NULL REFERENCES spring_schema.client(id) ON DELETE CASCADE
);