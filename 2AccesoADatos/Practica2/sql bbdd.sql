CREATE DATABASE hotelANC CHARSET utf8mb4 COLLATE utf8mb4_spanish2_ci;
USE hotelANC;

CREATE TABLE clienteanc (idCliente INT AUTO_INCREMENT, nombreCliente VARCHAR(45) NOT NULL, 
apellidosCliente VARCHAR(45) NOT NULL, emailCliente VARCHAR(200) NOT NULL, 
dniCliente VARCHAR(10) NOT NULL, 
claveCliente VARCHAR(45) NOT NULL,
PRIMARY KEY (idCliente)
);

SELECT * FROM clienteanc;
UPDATE hotelanc.clienteanc SET nombreCliente = 'Álvaro' WHERE idCliente = 1;
DELETE FROM hotelanc.clienteanc WHERE idCliente = 1;