package Reddit;
/*
 * Brandon Dalton
 * 09/16/2017
 * University of Southern California
 * Viterbi School of Engineering
 * Mass-IG
 * 
 * Main.java
 */

import java.util.Timer;

public class Main {
	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new CreateReddit(), 0, 10000);
	}

}
