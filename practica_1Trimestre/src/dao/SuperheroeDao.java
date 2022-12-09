package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Editorial;
import pojo.Superheroe;

public class SuperheroeDao extends ObjetoDao implements InterfazDao<Superheroe> {
	private Connection connection;

	@Override
	public void insertar(Superheroe t) {
		connection = openConnection();

		String query = "insert into superheroes(nombre,identidad_secreta,poderes,año_primera_aparicion,editorial_id)"
				+ "values(?,?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, t.getNombre());
			ps.setString(2, t.getIdentidad_secreta());
			ps.setString(3, t.getPoderes());
			ps.setInt(4, t.getAño_primera_aparicion());
			ps.setInt(5, t.getEditorial_id().getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();

	}

	@Override
	public void modificar(Superheroe t) {
		connection = openConnection();

		String query = "update superheroes SET nombre=?,identidad_secreta=?,poderes=?,año_primera_aparicion=? WHERE id =?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, t.getNombre());
			ps.setString(2, t.getIdentidad_secreta());
			ps.setString(3, t.getPoderes());
			ps.setInt(4, t.getAño_primera_aparicion());
			ps.setInt(5, t.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		
	}
	
	public void borrarTodos() {
		connection = openConnection();
		String query = "Delete from superheroes";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection();
		
	}
	
	public void truncateSuperheroe() {
		connection = openConnection();
		String query = "Truncate table superheroes";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection();
	}

	@Override
	public void borrar(Superheroe t) {
		connection = openConnection();

		String query = "Delete from superheroes where nombre=?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, t.getNombre());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();
	}

	public void borrarSuperId(int super_id) {
		connection = openConnection();

		String query = "Delete from superheroes Where editorial_id=?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, super_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();
	}

	@Override
	public ArrayList<Superheroe> buscarTodos() {
		ArrayList<Superheroe> heroes = new ArrayList<Superheroe>();
		connection = openConnection();
		Superheroe hero = null;
		String query = "Select*from superheroes";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				hero = new Superheroe(rs.getInt("id"), rs.getString("nombre"), rs.getString("identidad_secreta"),
						rs.getString("poderes"), rs.getShort("año_primera_aparicion"), null);
		
				
				heroes.add(hero);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return heroes;
	}

	@Override
	public Superheroe buscarPorNombre(String i) {
		connection = openConnection();
		Superheroe hero = null;
		String query = "Select*from superheroes where nombre=?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, i);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				hero = new Superheroe(rs.getInt("id"), rs.getString("nombre"), rs.getString("identidad_secreta"),
						rs.getString("poderes"), rs.getShort("año_primera_aparicion"), null);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();
		return hero;

	}

}
