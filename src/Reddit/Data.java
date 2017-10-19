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

import java.util.ArrayList;

public class Data {
	private String domain, approved_at_utc, banned_by, subreddit, selftext_html, selftext, likes, suggested_sort,
			secure_media, id, banned_utc, view_count, report_reasons, title, link_flair_text, approved_by, thumbnail,
			subreddit_id, link_flair_css_class, author_flair_css_class, removal_reason, author_flair_text,
			parent_whitelist_status, name, permalink, subreddit_type, url, whitelist_status, author,
			subreddit_name_prefixed, media, num_reports, distinguished, edited;

	public String getEdited() {
		return edited;
	}

	public boolean is_reddit_media_domain() {
		return is_reddit_media_domain;
	}

	public boolean isSaved() {
		return saved;
	}

	public boolean isArchived() {
		return archived;
	}

	public boolean isClicked() {
		return clicked;
	}

	public boolean isCan_mod_post() {
		return can_mod_post;
	}

	public boolean is_crosspostable() {
		return is_crosspostable;
	}

	public boolean isPinned() {
		return pinned;
	}

	public boolean isOver_18() {
		return over_18;
	}

	public boolean isHidden() {
		return hidden;
	}

	public boolean isContest_mode() {
		return contest_mode;
	}

	public boolean isBrand_safe() {
		return brand_safe;
	}

	public boolean isStickied() {
		return stickied;
	}

	public boolean isCan_gild() {
		return can_gild;
	}

	public boolean is_self() {
		return is_self;
	}

	public boolean isSpoiler() {
		return spoiler;
	}

	public boolean isLocked() {
		return locked;
	}

	public boolean isHide_score() {
		return hide_score;
	}

	public boolean isQuarantine() {
		return quarantine;
	}

	public boolean isVisited() {
		return visited;
	}

	public boolean is_video() {
		return is_video;
	}

	private double created, created_utc;
	private int num_crossposts, score, gilded, downs, ups, num_comments;
	private boolean is_reddit_media_domain, saved, archived, clicked, can_mod_post, is_crosspostable, pinned, over_18,
			hidden, contest_mode, brand_safe, stickied, can_gild, is_self, spoiler, locked, hide_score, quarantine,
			visited, is_video;

	private ArrayList<Report> user_reports;
	private ArrayList<Report> mod_reports;
	private Media media_embed;

	public String getDomain() {
		return domain;
	}

	public String getApproved_at_utc() {
		return approved_at_utc;
	}

	public String getBanned_by() {
		return banned_by;
	}

	public String getSubreddit() {
		return subreddit;
	}

	public String getSelftext_html() {
		return selftext_html;
	}

	public String getSelftext() {
		return selftext;
	}

	public String getLikes() {
		return likes;
	}

	public String getSuggested_sort() {
		return suggested_sort;
	}

	public String getSecure_media() {
		return secure_media;
	}

	public String getId() {
		return id;
	}

	public String getBanned_utc() {
		return banned_utc;
	}

	public String getView_count() {
		return view_count;
	}

	public String getReport_reasons() {
		return report_reasons;
	}

	public String getTitle() {
		return title;
	}

	public String getLink_flair_text() {
		return link_flair_text;
	}

	public String getApproved_by() {
		return approved_by;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public String getSubreddit_id() {
		return subreddit_id;
	}

	public String getLink_flair_css_class() {
		return link_flair_css_class;
	}

	public String getAuthor_flair_css_class() {
		return author_flair_css_class;
	}

	public String getRemoval_reason() {
		return removal_reason;
	}

	public String getAuthor_flair_text() {
		return author_flair_text;
	}

	public String getParent_whitelist_status() {
		return parent_whitelist_status;
	}

	public String getName() {
		return name;
	}

	public String getPermalink() {
		return permalink;
	}

	public String getSubreddit_type() {
		return subreddit_type;
	}

	public String getUrl() {
		return url;
	}

	public String getWhitelist_status() {
		return whitelist_status;
	}

	public String getAuthor() {
		return author;
	}

	public String getSubreddit_name_prefixed() {
		return subreddit_name_prefixed;
	}

	public String getMedia() {
		return media;
	}

	public String getNum_reports() {
		return num_reports;
	}

	public String getDistinguished() {
		return distinguished;
	}

	public int getNum_crossposts() {
		return num_crossposts;
	}

	public int getScore() {
		return score;
	}

	public int getGilded() {
		return gilded;
	}

	public int getDowns() {
		return downs;
	}

	public double getCreated() {
		return created;
	}

	public double getCreated_utc() {
		return created_utc;
	}

	public int getUps() {
		return ups;
	}

	public int getNum_comments() {
		return num_comments;
	}

	public ArrayList<Report> getUser_reports() {
		return user_reports;
	}

	public ArrayList<Report> getMod_reports() {
		return mod_reports;
	}

	public Media getMedia_embed() {
		return media_embed;
	}
}
