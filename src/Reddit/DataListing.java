package Reddit;

import java.util.ArrayList;

public class DataListing {
	private String modhash;
	private String whitelist_status;
	private ArrayList<Child> children;
	private String after;
	private String before;

	public String getModhash() {
		return modhash;
	}

	public String getWhitelist_status() {
		return whitelist_status;
	}

	public ArrayList<Child> getChildren() {
		return children;
	}

	public String getAfter() {
		return after;
	}

	public String getBefore() {
		return before;
	}
}
