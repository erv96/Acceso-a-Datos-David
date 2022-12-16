package pojo;

public class Superheroe {
	private int id;
	private String nombre;
	private String identidad_secreta;
	private String poderes;
	private short año_primera_aparicion;
	private Editorial editorial_id;
	private int editorial_numero;

	public Superheroe(int id, String nombre, String identidad_secreta, String poderes, short año_primera_aparicion,
			Editorial editorial_id) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.identidad_secreta = identidad_secreta;
		this.poderes = poderes;
		this.año_primera_aparicion = año_primera_aparicion;
		this.editorial_id = editorial_id;
	}

	public Superheroe(int id, String nombre, String identidad_secreta, String poderes, short año_primera_aparicion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.identidad_secreta = identidad_secreta;
		this.poderes = poderes;
		this.año_primera_aparicion = año_primera_aparicion;
	}


	public Superheroe(String nombre, String identidad_secreta, String poderes, short año_primera_aparicion,
			Editorial editorial_id) {
		super();
		this.nombre = nombre;
		this.identidad_secreta = identidad_secreta;
		this.poderes = poderes;
		this.año_primera_aparicion = año_primera_aparicion;
		this.editorial_id = editorial_id;
	}

	public int getEditorial_numero() {
		return editorial_numero;
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

	public String getIdentidad_secreta() {
		return identidad_secreta;
	}

	public void setIdentidad_secreta(String identidad_secreta) {
		this.identidad_secreta = identidad_secreta;
	}

	public String getPoderes() {
		return poderes;
	}

	public void setPoderes(String poderes) {
		this.poderes = poderes;
	}

	public short getAño_primera_aparicion() {
		return año_primera_aparicion;
	}

	public void setAño_primera_aparicion(short año_primera_aparicion) {
		this.año_primera_aparicion = año_primera_aparicion;
	}

	public Editorial getEditorial_id() {
		return editorial_id;
	}

	

	@Override
	public String toString() {
		return "\tID: " + id 
				+ "\n\tNOMBRE: " + nombre 
				+ "\n\tIDENTIDAD: " + identidad_secreta 
				+ "\n\tPODERES: "+ poderes 
				+ "\n\tPRIMERA APARICIÓN: " + año_primera_aparicion+"\n";
	}

}
