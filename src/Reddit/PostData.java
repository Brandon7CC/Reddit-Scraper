package Reddit;

import java.util.ArrayList;

public class PostData {
	private String subreddit_id, approved_at_utc, banned_by, removal_reason, link_id, likes, id, banned_at_utc,
			report_reasons, author, approved_by, author_flair_css_class, parent_id, collapsed_reason, body_html,
			subreddit, body, subreddit_type, name, author_flair_text, subreddit_name_prefixed, num_reports,
			distinguished, edited;

	private boolean saved, archived, can_mod_post, collapsed, is_submitter, stickied, can_gild, score_hidden;
	
	private boolean delta = false;

	private int gilded, ups, score, downs, created, created_utc, controversiality, depth, count;

	// TODO: Implement these classes!
	// private ArrayList<UserReport> user_reports;
	// private ArrayList<ModReports> mod_reports;
	private ArrayList<String> children;
	
	//private Reply replies;

	public String getSubreddit_id() {
		return subreddit_id;
	}
	
	public boolean getDelta() {
		return delta;
	}

	public String getApproved_at_utc() {
		return approved_at_utc;
	}

	public String getBanned_by() {
		return banned_by;
	}

	public String getRemoval_reason() {
		return removal_reason;
	}

	public String getLink_id() {
		return link_id;
	}

	public String getLikes() {
		return likes;
	}

	public String getId() {
		return id;
	}

	public String getBanned_at_utc() {
		return banned_at_utc;
	}

	public String getReport_reasons() {
		return report_reasons;
	}

	public String getAuthor() {
		return author;
	}

	public String getApproved_by() {
		return approved_by;
	}

	public String getAuthor_flair_css_class() {
		return author_flair_css_class;
	}

	public String getParent_id() {
		return parent_id;
	}

	public String getCollapsed_reason() {
		return collapsed_reason;
	}

	public String getBody_html() {
		return body_html;
	}

	public String getSubreddit() {
		return subreddit;
	}

	public String getBody() {
		return body;
	}

	public String getSubreddit_type() {
		return subreddit_type;
	}

	public String getName() {
		return name;
	}

	public String getAuthor_flair_text() {
		return author_flair_text;
	}

	public String getSubreddit_name_prefixed() {
		return subreddit_name_prefixed;
	}

	public String getNum_reports() {
		return num_reports;
	}

	public String getDistinguished() {
		return distinguished;
	}

	public boolean isSaved() {
		return saved;
	}

	public boolean isArchived() {
		return archived;
	}

	public boolean isCan_mod_post() {
		return can_mod_post;
	}

	public String isEdited() {
		return edited;
	}

	public boolean isCollapsed() {
		return collapsed;
	}

	public boolean isIs_submitter() {
		return is_submitter;
	}

	public boolean isStickied() {
		return stickied;
	}

	public boolean isCan_gild() {
		return can_gild;
	}

	public boolean isScore_hidden() {
		return score_hidden;
	}

	public int getGilded() {
		return gilded;
	}

	public int getUps() {
		return ups;
	}

	public int getScore() {
		return score;
	}

	public int getDowns() {
		return downs;
	}

	public int getCreated() {
		return created;
	}

	public int getCreated_utc() {
		return created_utc;
	}

	public int getControversiality() {
		return controversiality;
	}

	public int getDepth() {
		return depth;
	}

	public int getCount() {
		return count;
	}

	public ArrayList<String> getChildren() {
		return children;
	}

	/*
	public Reply getReplies() {
		return replies;
	}	
	*/
}
