import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Main {
	public static void main(String[] args) {
		String url = "https://www.reddit.com/user/ImnotfamousAMA/.json";
		System.out.println(getJson(url));
		
		
	}
	
	private static String getJson(String url) {
		Document doc;
		try {
			doc = Jsoup.connect(url).userAgent("chrome").ignoreContentType(true).timeout(0).get();
			String json = doc.getElementsByTag("body").toString();
			return json.substring(8, json.length()-7);
		} catch (IOException e) {
			System.out.println("JSON fetch error: " + e.getMessage());
		}
		return null;
	}
}
