CREATE DATABASE IF NOT EXISTS hoodies_district;

USE hoodies_district;

CREATE TABLE IF NOT EXISTS producto (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(150) NOT NULL,
    precio DOUBLE NOT NULL,
    cantidad INT NOT NULL
);