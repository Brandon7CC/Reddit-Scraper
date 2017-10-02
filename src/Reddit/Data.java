package Reddit;
/*
 * Brandon Dalton, Christopher Turner
 * 09/16/2017
 * University of Southern California
 * Viterbi School of Engineering
 * Mass-IG
 * 
 * Data.java
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

public class Data {
	private String subreddit = "", likes = "", score = "", author = "", num_comments = "", ups = "", downs = "",
			body = "", link_author = "", link_title = "", name = "", link_url = "", controversiality = "", link_id = "",
			id = "", created_utc = "", parent_id = "";
	private ArrayList<Data> comments = null;
	private ArrayList<Children> children = new ArrayList<>();

	public String getLink_id() {
		return link_id;
	}

	public void setLink_id(String link_id) {
		this.link_id = link_id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreated_utc() {
		Date date = new Date(Integer.parseInt(created_utc.substring(0, created_utc.length()-2)) *1000L);
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		format.setTimeZone(TimeZone.getTimeZone("PST"));
		
		return format.format(date);
	}

	public void setCreated_utc(String created_utc) {
		this.created_utc = created_utc;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getLink_author() {
		return link_author;
	}

	public void setLink_author(String link_author) {
		this.link_author = link_author;
	}

	public String getLink_title() {
		return link_title;
	}

	public void setLink_title(String link_title) {
		this.link_title = link_title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getControversiality() {
		return controversiality;
	}

	public void setControversiality(String controversiality) {
		this.controversiality = controversiality;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getLink_url() {
		return link_url;
	}

	public void setLink_url(String link_url) {
		this.link_url = link_url;
	}

	public ArrayList<Data> getComments() {
		return comments;
	}

	public void setComments(ArrayList<Data> comments) {
		this.comments = comments;
	}

	public String getParent_id() {
		return parent_id;
	}

	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}

}
