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
	private String domain, approved_at_utc, banned_by, subreddit, selftext_html, selftext, likes, suggested_sort,
			secure_media, id, banned_utc, view_count, report_reasons, title, link_flair_text, approved_by, thumbnail,
			subreddit_id, link_flair_css_class, author_flair_css_class, removal_reason, author_flair_text,
			parent_whitelist_status, name, permalink, subreddit_type, url, whitelist_status, author,
			subreddit_name_prefixed, media, num_reports, distinguished;
	
	private int num_crossposts, score, gilded, downs, created, created_utc, ups, num_comments;
	private boolean is_reddit_media_domain, saved, archived, clicked, can_mod_post, is_crosspostable, pinned, over_18,
			hidden, eddited, contest_mode, brand_safe, stickied, can_gild, is_self, spoiler, locked, hide_score,
			quarantine, visited, is_video;
	
	private ArrayList<Report> user_reports;
	private ArrayList<Report> mod_reports;
	private Media media_embed;
	

}
