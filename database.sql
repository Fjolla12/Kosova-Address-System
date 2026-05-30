CREATE DATABASE IF NOT EXISTS kosova_address_system;
USE kosova_address_system;

CREATE TABLE IF NOT EXISTS adresa (
    id INT AUTO_INCREMENT PRIMARY KEY,
    qyteti VARCHAR(100) NOT NULL,
    rruga VARCHAR(100) NOT NULL,
    numri VARCHAR(20) NOT NULL,
    kodi_postar VARCHAR(20) NOT NULL
);
