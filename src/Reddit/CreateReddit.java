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

import Tools.DatabaseFNS;
import Tools.WriteOut;


public class CreateReddit extends TimerTask{
	private Reddit reddit = null;
	private DatabaseFNS database = new DatabaseFNS();

	public CreateReddit(Reddit reddit) {
		this.reddit = reddit;
	}
	
	@Override
	public void run() {
		
		ArrayList<Children> children = reddit.getData().getChildren();
		for(Children c : children) {
			if(!database.existsInDB(c.getData())) {
				database.addToDB(c.getData());
			}
		}
		WriteOut.writeData(reddit);
	}
}
