package Tools;

public class CleanPost {
	public String cleanPost(String post) {
		if (post.contains("\\")) {
			int slashLocation = post.indexOf('\\');
			cleanPost(post.substring(0, slashLocation) + post.substring(slashLocation + 1, post.length()));
		}
		return post;
	}
}
