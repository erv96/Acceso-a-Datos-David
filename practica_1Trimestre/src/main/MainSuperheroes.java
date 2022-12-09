package main;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import dao.EditorialDao;
import dao.SuperheroeDao;
import pojo.Editorial;
import pojo.Superheroe;

public class MainSuperheroes {

	public static void main(String[] args) {
		/*Editorial marvel = new Editorial("Marvel","Martin",Date.valueOf("1939-1-10"));
		Editorial dc = new Editorial("DC","Jeje",Date.valueOf("1970-1-10"));
		EditorialDao edit = new EditorialDao();
		//edit.insertar(dc);
		Editorial marvelB = edit.buscarPorNombre("DC");
		Superheroe hola = new Superheroe("Hola","Original hola","saludar",(short)200,marvelB);
		Superheroe mem = new Superheroe("Prueba","soy yo","ser yo",(short)344,marvelB);
		SuperheroeDao pepe = new SuperheroeDao();
		//pepe.insertar(mem);
		edit.borrar(marvelB);*/
		
		Editorial marvel = new Editorial("Marvel","Martin",Date.valueOf("1939-1-10"));
		EditorialDao crear = new EditorialDao();
		//crear.insertar(marvel);
		Editorial marvelBuscar = crear.buscarPorNombre("Marvel");
		Superheroe hola = new Superheroe("Hola","Original hola","saludar",(short)200,marvelBuscar);
		
		SuperheroeDao insertar = new SuperheroeDao();
		//insertar.insertar(hola);
		
		System.out.println(insertar.buscarPorNombre("hola"));
		//insertar.borrar(hola);
		
		
		
		
		
		//edit.insertar(marvel);
		//edit.insertar(dc);
		/*ArrayList<Editorial> lista = edit.buscarTodos();
		for (Editorial editorial : lista) {
			System.out.println(editorial.getNombre());
		}*/
		//Editorial buscar = edit.buscarPorId(3);
		//buscar.setFundador_fundadores("TU");
		
		//edit.modificar(buscar);
		
	}

}
