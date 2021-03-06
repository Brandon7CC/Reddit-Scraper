package Tools;
/*
 * Brandon Dalton
 * 09/27/2017
 * University of Southern California
 * Viterbi School of Engineering
 * Mass-IG
 * 
 * CleanPosts.java
 */

public class CleanPost {
	// Cleans the posts through recursion
	public static String cleanPost(String post) {
		if (post.contains("'")) {
			int slashLocation = post.indexOf('\'');
			return cleanPost(
					post.substring(0, slashLocation) + "\"" + post.substring(slashLocation + 1, post.length()));
		}
		return post;
	}
}
