package prZoologicoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AnimalDAO {

	private static Connection connection;
	
	//Buscar animal por id 
	
	public static Animal findById(int id) {
		connection = openConnection();
		Animal animal = null;
		
		String query = "select * from animales where id=?";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				animal = new Animal(
						rs.getInt("id"),
						rs.getString("nombre"),
						rs.getDouble("peso_aproximado"),
						rs.getString("habitat"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		closeConnection();
		return animal;
	}
	
	//Borrar un animal dado su nombre 
	public static void deleteAnimalByNombre(String nombre) {
		connection = openConnection();
		String query = "delete from animales where nombre = ?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, nombre);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		
	}
	
	//Borrar todos los animales 
	public static void deleteAllAnimales() {
		connection = openConnection();
		
		String query = "delete from animales";
		
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(query);
			
			//Misma operacion con preparedStatement
			
			/*PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.executeUpdate();*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
	}
	
	//Insertar un animal 
	public static void insertAnimal(Animal animal) {
		connection = openConnection();

		String query = "INSERT INTO ANIMALES(nombre,peso_aproximado,habitat)values(?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, animal.getNombre());
			preparedStatement.setDouble(2, animal.getPeso_aproximado());
			preparedStatement.setString(3, animal.getHabitat());
			
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection();
	}

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
}
