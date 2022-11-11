package main;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import dao.EditorialDao;
import pojo.Editorial;

public class MainSuperheroes {

	public static void main(String[] args) {
		Editorial marvel = new Editorial("Marvel","Martin",Date.valueOf("1939-1-10"));
		Editorial dc = new Editorial("DC","Jeje",Date.valueOf("1970-1-10"));
		EditorialDao edit = new EditorialDao();
		//edit.insertar(marvel);
		//edit.insertar(dc);
		ArrayList<Editorial> lista = edit.buscarTodos();
		for (Editorial editorial : lista) {
			System.out.println(editorial.getNombre());
		}
		//Editorial buscar = edit.buscarPorId(3);
		//buscar.setFundador_fundadores("TU");
		
		//edit.modificar(buscar);
		
	}

}
