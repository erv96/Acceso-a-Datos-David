package pojo;

import java.util.ArrayList;

public class Serie {
	private int id;
	private String titulo;
	private int edad;
	private String plataforma;
	private ArrayList<Temporada> temporada;
	
	
	public Serie(String titulo, int edad, String plataforma) {
		super();
		this.titulo = titulo;
		this.edad = edad;
		this.plataforma = plataforma;
	}


	public Serie(int id, String titulo, int edad, String plataforma, ArrayList<Temporada> temporada) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.edad = edad;
		this.plataforma = plataforma;
		this.temporada = temporada;
	}



	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public String getPlataforma() {
		return plataforma;
	}


	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}


	public ArrayList<Temporada> getTemporada() {
		return temporada;
	}


	public void setTemporada(ArrayList<Temporada> temporada) {
		this.temporada = temporada;
	}


	public int getId() {
		return id;
	}


	@Override
	public String toString() {
		return "Serie [id=" + id + ", titulo=" + titulo + ", edad=" + edad + ", plataforma=" + plataforma + "]";
	}
	
	
	
	
}
