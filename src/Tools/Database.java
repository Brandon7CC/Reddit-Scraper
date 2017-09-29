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
import java.sql.Statement;

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
		String insertQuery = String.format(
				"insert into cmv.posts(subreddit,likes,score,author,num_comments,ups,downs,body,link_author,link_title,name,link_url,controversiality,link_id,id,created_utc) values('%s', '%s','%s', '%s','%s', '%s','%s', '%s','%s', '%s','%s', '%s','%s', '%s','%s', '%s')",
				d.getSubreddit(), d.getLikes(), d.getScore(), d.getAuthor(), d.getNum_comments(), d.getUps(),
				d.getDowns(), d.getBody(), d.getLink_author(), d.getLink_title(), d.getName(), d.getLink_url(),
				d.getControversiality(), d.getLink_id(), d.getId(), d.getCreated_utc());

		Statement st;
		try {
			st = conn.createStatement();
			st.executeUpdate(insertQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
