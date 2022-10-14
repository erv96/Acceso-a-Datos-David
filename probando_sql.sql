/*
	Crear tabla para guardar 
    alumnos 
    -id PK AUTO_INCREMENT
    -dni UNIQUE 
    -nombre
    -apellido_1
    -apellido_2
    -fecha_nacimiento

*/

use bd_alumnos; 

CREATE TABLE alumnos(
	id INT PRIMARY KEY AUTO_INCREMENT,
	dni VARCHAR(9) UNIQUE NOT NULL,
    nombre VARCHAR(30) NOT NULL,
    apellido_1 VARCHAR(30) NOT NULL,
    apellido_2 VARCHAR(30),
    fecha_nacimiento DATE NOT NULL
); 

SELECT*FROM alumnos;

INSERT INTO alumnos
	values(NULL,'09082311G','David','Toledo','Carrasco',"1996-06-22");

DELETE FROM alumnos WHERE nombre='David';
	

