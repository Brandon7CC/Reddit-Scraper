package Tools;
/*
 * Christopher Turner
 * 09/27/2017
 * University of Southern California
 * Viterbi School of Engineering
 * Mass-IG
 * 
 * Database.java
 * 
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
		
		String jdbcUrl = String.format(
				"jdbc:mysql://localhost/cmv?user=java&password=miturtc");

		Connection connection = null;
		try {
			connection = DriverManager.getConnection(jdbcUrl);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		conn = connection;
	}
}
