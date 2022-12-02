package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Superheroe;

public class SuperheroeDao extends ObjetoDao implements InterfazDao<Superheroe> {
	private Connection connection;
	@Override
	public void insertar(Superheroe t) {
		connection = openConnection();

		String query = "insert into superheroes(nombre,identidad_secreta,poderes,año_primera_aparicion,editorial_id)" + "values(?,?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, t.getNombre());
			ps.setString(2, t.getIdentidad_secreta());
			ps.setString(3, t.getPoderes());
			ps.setInt(4, t.getAño_primera_aparicion());
			ps.setInt(5,t.getEditorial_id().getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();
		
	}

	@Override
	public void modificar(Superheroe t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrar(Superheroe t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Superheroe> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Superheroe buscarPorNombre(String i) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
