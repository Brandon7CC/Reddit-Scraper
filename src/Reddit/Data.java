package Reddit;
/*
 * Brandon Dalton
 * 09/16/2017
 * University of Southern California
 * Viterbi School of Engineering
 * Mass-IG
 * 
 * Data.java
 */

import java.util.ArrayList;

public class Data {
	private String modhash = "", subreddit = "", likes = "", view_count = "", title = "", score = "", author = "",
			num_comments = "", ups = "", downs = "", selftext = "", url = "";
	private ArrayList<Children> children = new ArrayList<>();

	public String getModhash() {
		return modhash;
	}

	public void setModhash(String modhash) {
		this.modhash = modhash;
	}

	public ArrayList<Children> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<Children> children) {
		this.children = children;
	}

	public String getSubreddit() {
		return subreddit;
	}

	public void setSubreddit(String subreddit) {
		this.subreddit = subreddit;
	}

	public String getLikes() {
		return likes;
	}

	public void setLikes(String likes) {
		this.likes = likes;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getView_count() {
		return view_count;
	}

	public void setView_count(String view_count) {
		this.view_count = view_count;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNum_comments() {
		return num_comments;
	}

	public void setNum_comments(String num_comments) {
		this.num_comments = num_comments;
	}

	public String getUps() {
		return ups;
	}

	public void setUps(String ups) {
		this.ups = ups;
	}

	public String getDowns() {
		return downs;
	}

	public void setDowns(String downs) {
		this.downs = downs;
	}

	public String getSelftext() {
		return selftext;
	}

	public void setSelftext(String selftext) {
		this.selftext = selftext;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
