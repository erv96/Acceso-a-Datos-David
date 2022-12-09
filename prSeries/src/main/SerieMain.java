package main;

import java.util.ArrayList;
import java.util.Iterator;

import dao.SerieDao;
import dao.TemporadaDao;
import pojo.Serie;
import pojo.Temporada;

public class SerieMain {

	public static void main(String[] args) {		
		//Serie serie = new Serie("Los simpsons", 7,"Disney Plus");
		SerieDao serieDao = new SerieDao();
		//serieDao.insertar(serie);
		Serie mandarinas = new Serie("The Mandalorian",12,"Disney Plus");
		//serieDao.insertar(mandarinas);
		ArrayList<Serie> listaSerie = serieDao.buscarTodos();
		for (int i = 0; i < listaSerie.size(); i++) {
			System.out.println(listaSerie.get(i));
		}
		
		for (Serie recorrido : listaSerie) {
			System.out.println(recorrido.getTitulo());
		}
		
		Serie mandalorian = serieDao.buscarPorId(3);
		
		System.out.println(mandalorian);
		TemporadaDao delete = new TemporadaDao();
		TemporadaDao tempDao = new TemporadaDao();
		/*Temporada t1 = new Temporada(1,"Temproada 1",mandalorian);
		Temporada t2 = new Temporada(2,"Temporada 2",mandalorian);
		Temporada t3 = new Temporada(3,"Temporada final",mandalorian);
		
		tempDao.insertar(t1);
		tempDao.insertar(t2);
		tempDao.insertar(t3);*/
		
		
		ArrayList<Serie> series = serieDao.buscarTodos();
		
		for (Serie serie : series) {
			System.out.println("SERIE: "+serie.getTitulo());
			for (Temporada temporada : serie.getTemporada()) {
				System.out.println("TEMPORADA: "+temporada.getTitulo());
			}
		}
		
		//delete.insertar(tempSimp10);
		//delete.insertar(tempSimp9);
		//serieDao.borrar(serie1);
		
		/*serie1.setPlataforma("Neftlix");
		serieDao.modificar(serie1);*/
		/*ArrayList<Temporada> temporadas = serieDao.obtenerTemporadas(serie1);
		for (Temporada temp : temporadas) {
			System.out.println(temp);
		}*/
		
		/*Temporada tempSimp10 = new Temporada(10,"Temporada 10",serie1);

		TemporadaDao tempDao = new TemporadaDao();
		tempDao.insertar(tempSimp10);
		tempDao.insertar(tempSimp9);*/
		

	}
	

}
