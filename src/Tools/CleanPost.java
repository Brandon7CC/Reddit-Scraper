package Tools;

public class CleanPost {
	//Cleans the posts through recursion 
	public String cleanPost(String post) {
		if (post.contains("\\")) {
			System.out.println("Contains: \\");
			int slashLocation = post.indexOf('\\');
			return cleanPost(post.substring(0, slashLocation) + post.substring(slashLocation + 1, post.length()));
		} else if (post.contains(";")) {
			System.out.println("Contains ;");
			int slashLocation = post.indexOf(';');
			return cleanPost(post.substring(0, slashLocation) + post.substring(slashLocation + 1, post.length()));
		} else if (post.contains("\"")) {
			System.out.println("Contains \"");
			int slashLocation = post.indexOf('"');
			return cleanPost(post.substring(0, slashLocation) + post.substring(slashLocation + 1, post.length()));
		}
		return post;
	}
}
