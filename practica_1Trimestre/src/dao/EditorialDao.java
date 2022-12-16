package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Editorial;
import pojo.Superheroe;

public class EditorialDao extends ObjetoDao implements InterfazDao<Editorial> {
	private Connection connection;

	@Override
	public void insertar(Editorial t) {
		connection = openConnection();

		String query = "insert into editoriales(nombre,fundador_fundadores,fecha_fundacion)" + "values(?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, t.getNombre());
			ps.setString(2, t.getFundador_fundadores());
			ps.setDate(3, (Date) t.getFecha_fundacion());
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();
		
	}

	@Override
	public void modificar(Editorial t) {
		connection = openConnection();

		String query = "update editoriales SET Nombre=?,fundador_fundadores=?,fecha_fundacion=? WHERE id =?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, t.getNombre());
			ps.setString(2, t.getFundador_fundadores());
			ps.setDate(3, (Date)t.getFecha_fundacion());
			ps.setInt(4, t.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
	}
	


	@Override
	public void borrar(Editorial t) {
		int editorial_id = t.getId();
		
		SuperheroeDao superDao = new SuperheroeDao();
		superDao.borrarSuperId(editorial_id);
		
		connection = openConnection();
		String query = "delete from editoriales where id=?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, editorial_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();
		
	}
	
	public void truncateEditoriales() {
		connection = openConnection();
		String queryClaves = "SET FOREIGN_KEY_CHECKS = 0";
		String query = "Truncate table editoriales";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(queryClaves);
			ps.executeUpdate();
			ps = connection.prepareStatement(query);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection();
	}

	@Override
	public ArrayList<Editorial> buscarTodos() {
		ArrayList<Editorial> allEditoriales = new ArrayList<Editorial>();
		connection = openConnection();

		String query = "select*from editoriales";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ArrayList<Superheroe> superheroes = new ArrayList<Superheroe>();

				Editorial editorialActual = new Editorial(rs.getInt("id"),rs.getString("Nombre"), rs.getString("fundador_fundadores"),
						rs.getDate("fecha_fundacion"));
				
				allEditoriales.add(editorialActual);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();
		return allEditoriales;
	}

	@Override
	public Editorial buscarPorNombre(String nombre) {
		Editorial editorial = null;
		connection = openConnection();

		String query = "Select*from editoriales where nombre=?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, nombre);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				editorial = new Editorial(rs.getInt("id"), rs.getString("Nombre"), rs.getString("fundador_fundadores"),
						rs.getDate("fecha_fundacion"),null);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();

		return editorial;
	}
	
	public void borrarTodos() {
		connection = openConnection();
		String query = "Delete from editoriales";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection();
		
	}



}
