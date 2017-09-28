package Reddit;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/*
 * Brandon Dalton, Christopher Turner
 * 09/27/2017
 * University of Southern California
 * Viterbi School of Engineering
 * Mass-IG
 * 
 * CreateReddit.java
 * 
 * This class will be used to pull new data every 10 seconds.
 */
import java.util.ArrayList;
import java.util.TimerTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.google.gson.Gson;

import Tools.CleanPost;
import Tools.Database;

public class CreateReddit extends TimerTask {
	private Reddit reddit = null;
	private Database db = null;
	private CleanPost cleaner = new CleanPost();
	private Gson gson = new Gson();
	// Add the REST API link for the sub-reddit here
	private String url = "https://www.reddit.com/r/changemyview/.json";

	@Override
	public void run() {
		String json = getJson(this.url);
		this.reddit = gson.fromJson(json, Reddit.class);
		ArrayList<Children> children = reddit.getData().getChildren();
		db = new Database("christopher", "turner");
		try (Statement statement = db.getConn().createStatement()) {
			ResultSet resultSet = statement.executeQuery("SHOW TABLES");
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// for (Children c : children) {
		// Data d = c.getData();
		// d.setSelftext(cleaner.cleanPost(d.getSelftext()));
		//
		// if (!db.existsInDB(d)) {
		// db.add(d);
		// }
		// }
		// WriteOut.writeData(this.reddit);
	}

	// String -> String
	// Connects to the reddit page then returns the json file
	private static String getJson(String url) {
		Document doc;
		try {

			doc = Jsoup.connect(url).userAgent("chrome").ignoreContentType(true).timeout(0).get();
			String json = doc.getElementsByTag("body").toString();

			return json.substring(8, json.length() - 7);
		} catch (IOException e) {
			System.out.println("JSON fetch error: " + e.getMessage());
		}
		return null;
	}
}
