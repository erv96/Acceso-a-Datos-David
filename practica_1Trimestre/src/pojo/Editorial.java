package pojo;


import java.util.ArrayList;
import java.util.Date;

public class Editorial {
	private int id;
	private String nombre;
	private String fundador_fundadores;
	private Date fecha_fundacion;
	private ArrayList<Superheroe> listaSuperheroe;



	public Editorial(int id, String nombre, String fundador_fundadores, Date fecha_fundacion,
			ArrayList<Superheroe> listaSuperheroe) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fundador_fundadores = fundador_fundadores;
		this.fecha_fundacion = fecha_fundacion;
		this.listaSuperheroe = listaSuperheroe;
	}
	
	public Editorial(int id, String nombre, String fundador_fundadores, Date fecha_fundacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fundador_fundadores = fundador_fundadores;
		this.fecha_fundacion = fecha_fundacion;
	}
	
	

	public Editorial(String nombre, String fundador_fundadores, Date fecha_fundacion) {
		super();
		this.nombre = nombre;
		this.fundador_fundadores = fundador_fundadores;
		this.fecha_fundacion = fecha_fundacion;
	}



	public int getId() {
		return id;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFundador_fundadores() {
		return fundador_fundadores;
	}

	public void setFundador_fundadores(String fundador_fundadores) {
		this.fundador_fundadores = fundador_fundadores;
	}

	public Date getFecha_fundacion() {
		return fecha_fundacion;
	}

	public void setFecha_fundacion(Date fecha_fundacion) {
		this.fecha_fundacion = fecha_fundacion;
	}
	
	public ArrayList<Superheroe> getListaSuperheroe() {
		return listaSuperheroe;
	}

	public void setListaSuperheroe(ArrayList<Superheroe> listaSuperheroe) {
		this.listaSuperheroe = listaSuperheroe;
	}

	@Override
	public String toString() {
		return "\tID: " + id
				+ "\n\tNOMBRE: " + nombre 
				+ "\n\tFUNDADOR@ " + fundador_fundadores
				+ "\n\tFECHA DE FUNDACIÓN " + fecha_fundacion+"\n";
	}
	
	
	
	
	
	
}
