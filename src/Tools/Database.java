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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Reddit.Data;

public class Database {
	@SuppressWarnings("unused")
	private String username;
	@SuppressWarnings("unused")
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

	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean existsInDB(Data d) {
		String query = "SELECT COUNT(*) FROM cmv.posts WHERE id='" + d.getId() + "';";
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			if (rs.getInt(1) == 0) {
				return false;
			}
			else {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return true;
		}
	}

	public void add(Data d) {
		String insertQuery = String.format(
				"INSERT INTO cmv.posts(subreddit,author,num_comments,ups,downs,body,link_author,link_title,name,link_url,link_id,id,created_utc) values('%s','%s', '%s','%s', '%s','%s', '%s','%s', '%s','%s', '%s','%s', '%s')",
				d.getSubreddit(), d.getAuthor(), d.getNum_comments(), d.getUps(), d.getDowns(),
				d.getBody(), d.getLink_author(), d.getLink_title(), d.getName(), d.getLink_url(),
				d.getLink_id(), d.getId(), d.getCreated_utc());

		Statement st;
		try {
			st = conn.createStatement();
			st.executeUpdate(insertQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void connect() {
//		String instanceConnectionName = "mass-ig-172203:us-west1:reddit";
//		String databaseName = "cmv";

		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cmv?user=java&password=miturtc");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		conn = connection;
	}
}
