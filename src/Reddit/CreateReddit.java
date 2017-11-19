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
import java.util.Collections;
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
		System.out.println("comments: " + db.countComments());
		System.out.println("top level: " + db.countPosts());
		
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
			}
		}
		allData.clear();
		System.out.println("Query for new posts complete; querying for new comments...");
		ArrayList<String> postURLs = db.getPosts();
		Collections.shuffle(postURLs);
		for (String postURL : postURLs) {
			// Getting comments JSON
			json = getJson(postURL + ".json");
			//Hopefully this can fix our crashing issue
			if(json == null) {
				System.out.println("Skipping due to null – website not responding");
				continue;
			}
			json = json.replaceAll("\"replies\": \"\",", "");
			Type collectionType = new TypeToken<Collection<PostReddit>>() {
			}.getType();
			Collection<PostReddit> enums = gson.fromJson(json, collectionType);

			if (enums != null) {
				Iterator<PostReddit> it = enums.iterator();
				// Going through the comments
				while (it.hasNext()) {
					PostReddit pr = it.next();
					PostListing tempListing = pr.getData();
					findComments(tempListing);
				}
			}
		}
		String totalPosts = db.countPosts();
		String totalComments = db.countComments();
		System.out.println("Querying for comments complete.");
		System.out.println("Posts: " + totalPosts + ", Comments: " + totalComments + ".");
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

	private void findComments(PostListing pl) {
		for (PostChild child : pl.getChildren()) {
			PostData tempData = child.getData();
			if (tempData != null && tempData.getAuthor() != null) {
				if (tempData.getBody() != null) {
					if (!db.commentExistsInDB(tempData)
							&& (!tempData.getName().contains("t3") || tempData.getAuthor().equals("DeltaBot"))) {
						db.addComment(tempData);
						System.out.println("Added comment by: " + tempData.getAuthor());
						// System.out.println("CLASS: " + tempData.getAuthor_flair_css_class());

						if (tempData.getAuthor_flair_css_class() != null) {
							if (tempData.getAuthor_flair_css_class().equals("points")) {
								// System.out.println("Flair Class: Author: " + tempData.getAuthor() + ",
								// Text: " + tempData.getBody());
							}
						}

						if (tempData.getAuthor().equals("DeltaBot")
								&& tempData.getBody().contains("Confirmed: 1 delta awarded to")) {
							db.foundDelta(tempData.getParent_id());
							System.out.println("Δ Δ Δ Δ Δ Δ");
						}
					} else {
						if (tempData.getBody() != null) {
							db.updateComment(tempData);
							if (tempData.getAuthor_flair_css_class() != null) {
								if (tempData.getAuthor_flair_css_class().equals("points")) {
									// System.out.println("Flair Class: Author: " + tempData.getAuthor() + ",
									// Text: " + tempData.getBody());
								}
							}

							if (tempData.getAuthor().equals("DeltaBot")
									&& tempData.getBody().contains("Confirmed: 1 delta awarded to")) {
								db.foundDelta(tempData.getParent_id());
							}
						}
					}
					if (tempData.getReply() != null) {
						if (tempData.getReply().getData() != null) {
							findComments(tempData.getReply().getData());
						}
					}
				}

			}
		}
		return;
	}
}
