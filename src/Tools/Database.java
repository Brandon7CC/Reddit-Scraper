package Tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//CHRISTOPHER TURNER

import Reddit.Data;

public class Database {
	private String username;
	private String password;
	private Connection conn;

	public Database(String newUsername, String newPassword) {
		this.username = newUsername;
		this.password = newPassword;

		this.connect();
	}

	public Connection getConn() {
		return conn;
	}

	public boolean existsInDB(Data d) {

		return true;
	}

	public void add(Data d) {

	}

	private void connect() {
		String instanceConnectionName = "mass-ig-172203:us-west1:reddit";
		String databaseName = "cmv";

		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://35.203.162.89:3306/cmv?user=java");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		conn = connection;
	}
}
