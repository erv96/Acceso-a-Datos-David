package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Serie;
import pojo.Temporada;
import util.DataBaseConnection;

public class SerieDao extends ObjetoDao implements InterfazDao<Serie> {
	private Connection connection;

	public SerieDao() {

	}

	@Override
	public void insertar(Serie t) {
		connection = openConnection();

		String query = "insert into series(titulo,edad,plataforma)" + "values(?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, t.getTitulo());
			ps.setInt(2, t.getEdad());
			ps.setString(3, t.getPlataforma());
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();
	}

	@Override
	public void modificar(Serie t) {
		connection = openConnection();

		String query = "update series SET titulo=?,edad=?,plataforma=? WHERE id =?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, t.getTitulo());
			ps.setInt(2, t.getEdad());
			ps.setString(3, t.getPlataforma());
			ps.setInt(4, t.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();

	}

	public ArrayList<Temporada> obtenerTemporada(Serie serie) {
		ArrayList<Temporada> temporadas = new ArrayList<>();
		connection = openConnection();

		String query = "SELECT * FROM temporadas WHERE serie_id=?";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, serie.getId());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Temporada temp = new Temporada(rs.getInt("id"), rs.getInt("num_temporada"), rs.getString("titulo"),
						serie);
				temporadas.add(temp);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//closeConnection();
		return temporadas;
	}
	
	public ArrayList<Temporada> obtenerTemporadaPorId(int serie_id) {
		ArrayList<Temporada> temporadas = new ArrayList<>();
		connection = openConnection();

		String query = "SELECT * FROM temporadas WHERE serie_id=?";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, serie_id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Temporada temp = new Temporada(rs.getInt("id"), rs.getInt("num_temporada"), rs.getString("titulo"),
						buscarPorId(serie_id));
				temporadas.add(temp);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();
		return temporadas;
	}

	@Override
	public void borrar(Serie t) {
		connection = openConnection();
		String query = "delete from series where id=?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, t.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection();
	}

	@Override
	public ArrayList<Serie> buscarTodos() {
		ArrayList<Serie> allSeries = new ArrayList<Serie>();
		connection = openConnection();

		String query = "select*from series";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Serie serieActual = new Serie(rs.getString("titulo"), rs.getInt("edad"), rs.getString("plataforma"));
				allSeries.add(serieActual);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();
		return allSeries;
	}

	@Override
	public Serie buscarPorId(int id) {
		Serie serie = null;
		connection = openConnection();

		String query = "Select*from series where id=?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				serie = new Serie(rs.getInt("id"), rs.getString("Titulo"), rs.getInt("edad"),
						rs.getString("plataforma"), null);
				serie.setTemporada(obtenerTemporada(serie));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();

		return serie;
	}

}
