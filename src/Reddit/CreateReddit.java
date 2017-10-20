package Reddit;
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

import java.io.IOException;
import java.util.ArrayList;
import java.util.TimerTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.google.gson.Gson;

import Tools.Database;

public class CreateReddit extends TimerTask {

	private Reddit reddit = null;
	private Post post = null;
	private Database db = null;
	private Gson gson = new Gson();
	// Add the REST API link for the sub-reddit here
	private String url = "https://www.reddit.com/r/changemyview/.json";

	public CreateReddit(Database myDB) {
		db = myDB;
	}

	@Override
	public void run() {
		String json = getJson(this.url);
		this.reddit = gson.fromJson(json, Reddit.class);
		ArrayList<Data> allData = new ArrayList<Data>();
		for (Child c : reddit.getData().getChildren()) {
			allData.add(c.getData());
		}

		if (allData != null && allData.size() > 0) {
			for (Data d : allData) {
				if (!db.existsInDB(d)) {
					db.add(d);
					System.out.println("Added post: " + d.getTitle());
				} else {
					db.update(d);
				}
				
				json = getJson(d.getUrl() + ".json");
				this.post = gson.fromJson(json, Post.class);
				System.out.println("Here are the authors of the comments!");
				for(PostReddit pr : this.post.getReddits()) {
					PostListing tempListing = pr.getData();
					for(PostChild child : tempListing.getChildren()) {
						PostData tempData = child.getData();
						System.out.println(tempData.getAuthor());
					}
				}
			}
		}
		allData.clear();
		String totalPosts = db.countPosts();
		System.out.println("Queried for new top-level posts. Running total: " + totalPosts + " posts.");
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
