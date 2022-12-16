use bd_superheroes;

CREATE TABLE editoriales(
	id INT PRIMARY KEY AUTO_INCREMENT,
	Nombre VARCHAR(100),
    fundador_fundadores VARCHAR(300),
    fecha_fundacion DATE
);

CREATE TABLE superheroes(
	id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100)  NOT NULL,
    identidad_secreta VARCHAR(100)  NOT NULL,
    poderes VARCHAR(1000) NOT NULL,
    año_primera_aparicion NUMERIC(4),
    editorial_id INT NOT NULL,
     CONSTRAINT FK_editorial_superheroe
		FOREIGN KEY (Editorial_id)
        REFERENCES editoriales(id)

);

SELECT*FROM editoriales;
SELECT*FROM superheroes;
