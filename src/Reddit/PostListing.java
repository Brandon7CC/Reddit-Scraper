/*
 * Brandon Dalton, Christopher Turner
 * 10/19/2017
 * University of Southern California
 * Viterbi School of Engineering
 * Mass-IG
 * 
 * PostListing.java
 */

package Reddit;

import java.util.ArrayList;

public class PostListing {
	private String modhash, whitelist_status, after, before;
	private ArrayList<PostChild> children;

	public String getModhash() {
		return modhash;
	}

	public ArrayList<PostChild> getChildren() {
		return children;
	}

	public String getWhitelist_status() {
		return whitelist_status;
	}

	public String getAfter() {
		return after;
	}

	public String getBefore() {
		return before;
	}
	
}
