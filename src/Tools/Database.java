package Tools;
/*
 * Christopher Turner
 * 09/27/2017
 * University of Southern California
 * Viterbi School of Engineering
 * Mass-IG
 * 
 * Database.java
 * 
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Reddit.Data;
import Reddit.PostData;

public class Database {
	@SuppressWarnings("unused")
	private String username;
	@SuppressWarnings("unused")
	private String password;
	private Connection conn;

	public Database(String newUsername, String newPassword) {
		this.username = newUsername;
		this.password = newPassword;
		this.connect();
		System.out.println("Connected to database; querying for new top-level posts...");
	}

	public Connection getConn() {
		return conn;
	}

	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean postExistsInDB(Data d) {
		String query = "SELECT COUNT(*) FROM cmv.posts WHERE id='" + d.getId() + "';";
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			if (rs.getInt(1) == 0) {
				return false;
			} else {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return true;
		}
	}
	
	public boolean commentExistsInDB(PostData tempData) {
		String query = "SELECT COUNT(*) FROM cmv.comments WHERE id='" + tempData.getId() + "';";
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			if (rs.getInt(1) == 0) {
				return false;
			} else {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return true;
		}
	}

	public void addPost(Data d) {
		String command = "INSERT INTO cmv.posts(";
		String params = "id,domain,approved_at_utc,banned_by,subreddit,selftext_html,selftext,likes,suggested_sort,secure_media,is_reddit_media_domain,saved,banned_at_utc,view_count,archived,clicked,report_reasons,title,num_crossposts,link_flair_text,can_mod_post,is_crosspostable,pinned,score,approved_by,over_18,hidden,thumbnail,subreddit_id,edited,link_flair_css_class,author_flair_css_class,contest_mode,gilded,downs,brand_safe,removal_reason,author_flair_text,stickied,can_gild,is_self,parent_whitelist_status,name,permalink,subreddit_type,locked,hide_score,created,url,whitelist_status,quarantine,author,created_utc,subreddit_name_prefixed,ups,media,num_comments,visited,num_reports,is_video,distinguished";
		String separator1 = ") values(";
		String valuePlaceholders = "'%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s'";
		String separator2 = ")";
		String insertQuery = String.format(command + params + separator1 + valuePlaceholders + separator2, d.getId(),
				d.getDomain(), d.getApproved_at_utc(), d.getBanned_by(), d.getSubreddit(),
				CleanPost.cleanPost(d.getSelftext_html()), CleanPost.cleanPost(d.getSelftext()), d.getLikes(),
				d.getSuggested_sort(), d.getSecure_media(), (d.is_reddit_media_domain()) ? 1 : 0, (d.isSaved()) ? 1 : 0,
				d.getBanned_utc(), d.getView_count(), (d.isArchived()) ? 1 : 0, (d.isClicked()) ? 1 : 0,
				d.getReport_reasons(), CleanPost.cleanPost(d.getTitle()), d.getNum_crossposts(), d.getLink_flair_text(),
				(d.isCan_mod_post()) ? 1 : 0, (d.is_crosspostable()) ? 1 : 0, (d.isPinned()) ? 1 : 0, d.getScore(),
				d.getApproved_by(), (d.isOver_18()) ? 1 : 0, (d.isHidden()) ? 1 : 0, d.getThumbnail(),
				d.getSubreddit_id(), d.getEdited(), d.getLink_flair_css_class(), d.getAuthor_flair_css_class(),
				(d.isContest_mode()) ? 1 : 0, d.getGilded(), d.getDowns(), (d.isBrand_safe()) ? 1 : 0,
				d.getRemoval_reason(), d.getAuthor_flair_text(), (d.isStickied()) ? 1 : 0, (d.isCan_gild()) ? 1 : 0,
				(d.is_self()) ? 1 : 0, d.getParent_whitelist_status(), d.getName(), d.getPermalink(),
				d.getSubreddit_type(), (d.isLocked()) ? 1 : 0, (d.isHide_score()) ? 1 : 0, d.getCreated(), d.getUrl(),
				d.getWhitelist_status(), (d.isQuarantine()) ? 1 : 0, d.getAuthor(), d.getCreated_utc(),
				d.getSubreddit_name_prefixed(), d.getUps(), d.getMedia(), d.getNum_comments(), (d.isVisited()) ? 1 : 0,
				d.getNum_reports(), (d.is_video()) ? 1 : 0, d.getDistinguished());

		Statement st;
		try {
			st = conn.createStatement();
			st.executeUpdate(insertQuery);
		} catch (SQLException e) {
			System.out.println("Insertion could not be completed for ID: " + d.getId());
			System.exit(0);
		}
	}

	public void updatePost(Data d) {
		String updateQuery = "UPDATE cmv.posts SET domain = ? , " + "approved_at_utc = ? , " + "banned_by = ? , "
				+ "subreddit = ? , " + "selftext_html = ? , " + "selftext = ? , " + "likes = ? , "
				+ "suggested_sort = ? , " + "secure_media = ? , " + "is_reddit_media_domain = ? , " + "saved = ? , "
				+ "banned_at_utc = ? , " + "view_count = ? , " + "archived = ? , " + "clicked = ? , "
				+ "report_reasons = ? , " + "title = ? , " + "num_crossposts = ? , " + "link_flair_text = ? , "
				+ "can_mod_post = ? , " + "is_crosspostable = ? , " + "pinned = ? , " + "score = ? , "
				+ "approved_by = ? , " + "over_18 = ? , " + "hidden = ? , " + "thumbnail = ? , " + "subreddit_id = ? , "
				+ "edited = ? , " + "link_flair_css_class = ? , " + "author_flair_css_class = ? , "
				+ "contest_mode = ? , " + "gilded = ? , " + "downs = ? , " + "brand_safe = ? , "
				+ "removal_reason = ? , " + "author_flair_text = ? , " + "stickied = ? , " + "can_gild = ? , "
				+ "is_self = ? , " + "parent_whitelist_status = ? , " + "name = ? , " + "permalink = ? , "
				+ "subreddit_type = ? , " + "locked = ? , " + "hide_score = ? , " + "created = ? , " + "url = ? , "
				+ "whitelist_status = ? , " + "quarantine = ? , " + "author = ? , " + "created_utc = ? , "
				+ "subreddit_name_prefixed = ? , " + "ups = ? , " + "media = ? , " + "num_comments = ? , "
				+ "visited = ? , " + "num_reports = ? , " + "is_video = ? , " + "distinguished = ? WHERE id = ?";

		try (PreparedStatement st = conn.prepareStatement(updateQuery)) {
			st.setString(1, d.getDomain());
			st.setString(2, d.getApproved_at_utc());
			st.setString(3, d.getBanned_by());
			st.setString(4, d.getSubreddit());
			st.setString(5, CleanPost.cleanPost(d.getSelftext_html()));
			st.setString(6, CleanPost.cleanPost(d.getSelftext()));
			st.setString(7, d.getLikes());
			st.setString(8, d.getSuggested_sort());
			st.setString(9, d.getSecure_media());
			st.setBoolean(10, d.is_reddit_media_domain());
			st.setBoolean(11, d.isSaved());
			st.setString(12, d.getBanned_utc());
			st.setString(13, d.getView_count());
			st.setBoolean(14, d.isArchived());
			st.setBoolean(15, d.isClicked());
			st.setString(16, d.getReport_reasons());
			st.setString(17, CleanPost.cleanPost(d.getTitle()));
			st.setInt(18, d.getNum_crossposts());
			st.setString(19, d.getLink_flair_text());
			st.setBoolean(20, d.isCan_mod_post());
			st.setBoolean(21, d.is_crosspostable());
			st.setBoolean(22, d.isPinned());
			st.setInt(23, d.getScore());
			st.setString(24, d.getApproved_by());
			st.setBoolean(25, d.isOver_18());
			st.setBoolean(26, d.isHidden());
			st.setString(27, d.getThumbnail());
			st.setString(28, d.getSubreddit_id());
			st.setString(29, d.getEdited());
			st.setString(30, d.getLink_flair_css_class());
			st.setString(31, d.getAuthor_flair_css_class());
			st.setBoolean(32, d.isContest_mode());
			st.setInt(33, d.getGilded());
			st.setInt(34, d.getDowns());
			st.setBoolean(35, d.isBrand_safe());
			st.setString(36, d.getRemoval_reason());
			st.setString(37, d.getAuthor_flair_text());
			st.setBoolean(38, d.isStickied());
			st.setBoolean(39, d.isCan_gild());
			st.setBoolean(40, d.is_self());
			st.setString(41, d.getParent_whitelist_status());
			st.setString(42, d.getName());
			st.setString(43, d.getPermalink());
			st.setString(44, d.getSubreddit_type());
			st.setBoolean(45, d.isLocked());
			st.setBoolean(46, d.isHide_score());
			st.setDouble(47, d.getCreated());
			st.setString(48, d.getUrl());
			st.setString(49, d.getWhitelist_status());
			st.setBoolean(50, d.isQuarantine());
			st.setString(51, d.getAuthor());
			st.setDouble(52, d.getCreated_utc());
			st.setString(53, d.getSubreddit_name_prefixed());
			st.setInt(54, d.getUps());
			st.setString(55, d.getMedia());
			st.setInt(56, d.getNum_comments());
			st.setBoolean(57, d.isVisited());
			st.setString(58, d.getNum_reports());
			st.setBoolean(59, d.is_video());
			st.setString(60, d.getDistinguished());
			st.setString(61, d.getId());
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Update could not be completed for ID: " + d.getId());
			System.exit(0);
		}
	}

	private void connect() {
		// String instanceConnectionName = "mass-ig-172203:us-west1:reddit";
		// String databaseName = "cmv";

		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cmv?user=java&password=miturtc");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		conn = connection;
	}

	public String countPosts() {
		String out = "";
		try (Statement statement = conn.createStatement()) {
			ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM posts;");
			while (resultSet.next()) {
				out = resultSet.getString(1);
			}
			return out.trim();
		} catch (SQLException e) {
			System.out.println("Post count could not be updated.");
			System.exit(0);
		}
		return out;
	}

	public void addComment(PostData tempData) {
		// TODO Auto-generated method stub
		
	}

	public void updateComment(PostData tempData) {
		// TODO Auto-generated method stub
		
	}
}
