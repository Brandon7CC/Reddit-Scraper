package Reddit;
/*
 * Brandon Dalton
 * 09/27/2017
 * University of Southern California
 * Viterbi School of Engineering
 * Mass-IG
 * 
 * CreateReddit.java
 * 
 * This class will be used to pull new data every 10 seconds.
 */
import java.util.ArrayList;
import java.util.TimerTask;

import Tools.CleanPost;
import Tools.DatabaseFNS;
import Tools.WriteOut;


public class CreateReddit extends TimerTask{
	private Reddit reddit = null;
	private DatabaseFNS database = new DatabaseFNS();
	private CleanPost cleaner = new CleanPost();

	public CreateReddit(Reddit reddit) {
		this.reddit = reddit;
	}
	
	@Override
	public void run() {
		
		ArrayList<Children> children = reddit.getData().getChildren();
		for(Children c : children) {
			Data d = c.getData();
			d.setSelftext(cleaner.cleanPost(d.getSelftext()));
			
			if(!database.existsInDB(d)) {
				database.addToDB(d);
			}
		}
		//WriteOut.writeData(reddit);
	}
}
