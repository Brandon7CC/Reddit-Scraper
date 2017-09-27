package Reddit;
/*
 * Brandon Dalton
 * 09/16/2017
 * University of Southern California
 * Viterbi School of Engineering
 * Mass-IG
 * 
 * Main.java
 */


import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import Tools.WriteOut;

public class Main {
	public static void main(String[] args) {
		//Add the REST API link for the sub-reddit here
		String url = "https://www.reddit.com/r/changemyview/.json";
		
		try {
			Gson gson = new Gson();
			String json = getJson(url);
			System.out.println(json);
			Reddit reddit = gson.fromJson(json, Reddit.class);
			WriteOut.writeData(reddit);
		} catch (JsonSyntaxException e) {
			System.out.println("Json format error! " + e.getMessage());
		}
		
		
	}
	
	//String -> String
	//Connects to the reddit page then returns the json file
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
