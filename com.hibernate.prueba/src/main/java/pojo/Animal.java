package pojo;
// Generated 25 nov 2022, 12:19:02 by Hibernate Tools 5.5.9.Final

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Animales generated by hbm2java
 */
@Entity
@Table(name = "animales")
public class Animal implements java.io.Serializable {
	
	//SI EL NOMBRE EN LA BASE DE DATOS ES UNIQUE Y NOT NULL SE PONE (name = "nombre", unique=true, nullable = false)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nombre", unique = true, nullable = false, length = 40)
	private String nombre;
	
	@Column(name = "peso_aproximado",nullable = false, length = 10, precision = 2)
	private BigDecimal pesoAproximado;
	
	@Column(name = "habitat", nullable = false, length = 40)
	private String habitat;

	public Animal() {
	}

	public Animal(String nombre,String habitat,BigDecimal pesoAproximado) {
		this.nombre = nombre;
		this.pesoAproximado = pesoAproximado;
		this.habitat = habitat;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPesoAproximado() {
		return this.pesoAproximado;
	}

	public void setPesoAproximado(BigDecimal pesoAproximado) {
		this.pesoAproximado = pesoAproximado;
	}

	public String getHabitat() {
		return this.habitat;
	}

	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}

}
