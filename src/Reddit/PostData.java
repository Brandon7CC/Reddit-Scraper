package Reddit;

import java.util.ArrayList;

public class PostData {
	private String subreddit_id, approved_at_utc, banned_by, removal_reason, link_id, likes, replies, id, banned_at_utc,
			report_reasons, author, approved_by, author_flair_css_class, parent_id, collapsed_reason, body_html,
			subreddit, body, subreddit_type, name, author_flair_text, subreddit_name_prefixed, num_reports,
			distinguished;

	private boolean saved, archived, can_mod_post, edited, collapsed, is_submitter, stickied, can_gild, score_hidden;

	// TODO: Implement these classes!
	// private ArrayList<UserReport> user_reports;
	// private ArrayList<ModReports> mod_reports;
	private ArrayList<String> children;
}
