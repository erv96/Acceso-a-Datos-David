package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Serie;
import util.DataBaseConnection;

public class SerieDao implements Dao<Serie> {
	
	public SerieDao() {
		
	}

	private static Connection connection;

	private static Connection openConnection() {
		DataBaseConnection dbConnection = new DataBaseConnection();
		connection = dbConnection.getConnection();
		return connection;
	}

	private static void closeConnection() {
		try {
			connection.close();
			connection = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		// TODO Auto-generated method stub

	}

	@Override
	public void borrar(Serie t) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Serie> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serie buscarPorId(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
