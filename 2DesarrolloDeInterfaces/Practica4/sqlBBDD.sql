CREATE DATABASE tiendecitaanc CHARSET utf8mb4 COLLATE utf8mb4_spanish2_ci;
USE tiendecitaanc;

CREATE TABLE articulos (idArticulo INT AUTO_INCREMENT, descripcionArticulo VARCHAR(200) NOT NULL, precioArticulo DOUBLE(6,2) NOT NULL, stockArticulo INT NOT NULL, 
PRIMARY KEY (idArticulo)
);

CREATE TABLE tickets (idTicket INT AUTO_INCREMENT, fechaTicket DATE NOT NULL, precioTotal DECIMAL(6,2),
PRIMARY KEY (idTicket)
);

CREATE TABLE historico (idHistorico INT AUTO_INCREMENT, idTicketFK INT NOT NULL, idArticuloFK INT NOT NULL, cantidadArticulo INT NOT NULL,
PRIMARY KEY (idHistorico),
FOREIGN KEY (idTicketFK)
REFERENCES tickets(idTicket),
FOREIGN KEY (idArticuloFK)
REFERENCES articulos(idArticulo)
);
DROP TABLE historico;
TRUNCATE TABLE articulos;
TRUNCATE TABLE tickets;