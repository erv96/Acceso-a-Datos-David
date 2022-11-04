package main;

import java.util.ArrayList;

import dao.SerieDao;
import dao.TemporadaDao;
import pojo.Serie;
import pojo.Temporada;

public class SerieMain {

	public static void main(String[] args) {		
		Serie serie = new Serie("Los simpsons", 7,"Disney Plus");
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
		
		Serie serie1 = serieDao.buscarPorId(1);
		serie1.setPlataforma("Neftlix");
		serieDao.modificar(serie1);
		ArrayList<Temporada> temporadas = serieDao.obtenerTemporadas(serie1);
		for (Temporada temp : temporadas) {
			System.out.println(temp);
		}
		
		/*Temporada tempSimp10 = new Temporada(10,"Temporada 10",serie1);
		Temporada tempSimp9 = new Temporada(9,"Temporada 9",serie1);

		TemporadaDao tempDao = new TemporadaDao();
		tempDao.insertar(tempSimp10);
		tempDao.insertar(tempSimp9);*/
		

	}
	

}
