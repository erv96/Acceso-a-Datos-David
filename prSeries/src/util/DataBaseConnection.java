package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

	Connection connection;

	public Connection getConnection() {
		String dbName = "bd_series";
		String userName = "root";
		String password = "123koalaenfermo";
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://localhost/" + dbName, userName, password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

}
