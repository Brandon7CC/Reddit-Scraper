package Reddit;
/*
 * Brandon Dalton, Christopher Turner
 * 09/16/2017
 * University of Southern California
 * Viterbi School of Engineering
 * Mass-IG
 * 
 * Main.java
 */

import java.util.Timer;

import Tools.Database;

public class Main {
	public static void main(String[] args) {
		Timer timer = new Timer();
		Database db = new Database("java","miturtc");
		timer.schedule(new CreateReddit(db), 0, 10000);
	}

}
