use bd_zoologico;

CREATE TABLE animales(
	id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(40),
    peso_aproximado NUMERIC(10,2),
    habitat VARCHAR(40)
);

SELECT*FROM animales;
