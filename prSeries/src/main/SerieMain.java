package main;

import dao.SerieDao;
import pojo.Serie;

public class SerieMain {

	public static void main(String[] args) {
		Serie serie = new Serie("Los simpsons", 7,"Disney Plus");
		SerieDao serieDao = new SerieDao();
		serieDao.insertar(serie);
	}

}
