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
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.TimerTask;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import Tools.Database;

public class CreateReddit extends TimerTask {

	private Reddit reddit = null;
	private Database db = null;
	private Gson gson = new Gson();
	// Add the REST API link for the sub-reddit here
	private String baseURL = "https://www.reddit.com/r/";
	private String subreddit = "changemyview";
	private String jsonURL = baseURL + subreddit + "/.json";

	public CreateReddit(Database myDB) {
		db = myDB;
	}

	@Override
	public void run() {
		String json = getJson(this.jsonURL);
		this.reddit = gson.fromJson(json, Reddit.class);
		ArrayList<Data> allData = new ArrayList<Data>();
		for (Child c : reddit.getData().getChildren()) {
			allData.add(c.getData());
		}

		if (allData != null && allData.size() > 0) {
			for (Data d : allData) {
				if (!db.postExistsInDB(d)) {
					 db.addPost(d);
					System.out.println("Added post: " + d.getTitle());
				} else {
					 db.updatePost(d);
				}

				// Getting comments JSON
				json = getJson(d.getUrl() + ".json");
				Type collectionType = new TypeToken<Collection<PostReddit>>() {
				}.getType();
				Collection<PostReddit> enums = gson.fromJson(json, collectionType);

				if (enums != null) {
					Iterator<PostReddit> it = enums.iterator();
					// Going through the comments
					while (it.hasNext()) {
						PostReddit pr = it.next();
						PostListing tempListing = pr.getData();
						for (PostChild child : tempListing.getChildren()) {
							PostData tempData = child.getData();
							// As you can see here we can get info specific to the comment from the
							// [PostData object].
							// System.out.println(tempData.getAuthor() + " " + d.getTitle());
							if (!db.commentExistsInDB(tempData)) {
//								 db.addComment(tempData);
							} else {
//								 db.updateComment(tempData);
							}
						}
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
			Connection con = Jsoup.connect(url).userAgent("Chrome").ignoreHttpErrors(true).ignoreContentType(true)
					.timeout(30000);
			Connection.Response resp = con.execute();
			if (resp.statusCode() == 200) {
				doc = con.get();
				String json = doc.getElementsByTag("body").toString();
				return json.substring(8, json.length() - 7);
			}
			// doc =
			// Jsoup.connect(url).userAgent("chrome").ignoreContentType(true).timeout(10000).get();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
