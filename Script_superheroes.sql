use bd_superheroes;

CREATE TABLE editoriales(
	id INT PRIMARY KEY AUTO_INCREMENT,
	Nombre VARCHAR(100),
    fundador_fundadores VARCHAR(300),
    fecha_fundacion DATE
);

CREATE TABLE superheroes(
	id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) UNIQUE NOT NULL,
    identidad_secreta VARCHAR(100) UNIQUE NOT NULL,
    poderes VARCHAR(1000) NOT NULL,
    año_primera_aparicion NUMERIC(4),
    editorial_id INT NOT NULL,
     CONSTRAINT FK_editorial_superheroe
		FOREIGN KEY (Editorial_id)
        REFERENCES editoriales(id)

);

INSERT INTO editoriales (nombre,fundador_fundadores) values("prueba","yo");

SELECT*FROM editoriales;
ALTER TABLE editoriales auto_increment = 1;
SELECT*FROM superheroes;
DELETE FROM editoriales;
SET SQL_SAFE_UPDATES = 0;

SET FOREIGN_KEY_CHECKS = 0; 
TRUNCATE table editoriales; 
SET FOREIGN_KEY_CHECKS = 1;