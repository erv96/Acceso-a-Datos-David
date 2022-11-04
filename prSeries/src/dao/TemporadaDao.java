package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Serie;
import pojo.Temporada;
import util.DataBaseConnection;

public class TemporadaDao extends ObjetoDao implements InterfazDao<Temporada>{
	
	private static Connection connection;

	@Override
	public void insertar(Temporada t) {
		connection = openConnection();
		String query = "Insert into temporadas (num_temporada,titulo,serie_id)"
				+ "values(?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, t.getNum_temporada());
			ps.setString(2, t.getTitulo());
			ps.setInt(3, t.getSerie().getId());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		closeConnection();
		
	}

	@Override
	public void modificar(Temporada t) {
		
	}

	@Override
	public void borrar(Temporada t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Temporada> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Temporada buscarPorId(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
