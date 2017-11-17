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

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Timer;
import Tools.Database;

public class Main {
	private static FileWriter fw; 
	public static void main(String[] args) {
		boolean needsHelp = true;
		while (needsHelp) {
			try {
				needsHelp = false;
				Timer timer = new Timer();
				Database db = new Database("java", "miturtc");
				timer.schedule(new CreateReddit(db), 0, 1200000);
			} catch (Exception e) {
				try {
					System.out.println("There has been an error! Restarting Main!");
					fw = new FileWriter(new File("crashLogs.txt"));
					fw.write("Error occured at " + System.currentTimeMillis() + " UTC time. Here is the error: \n" + e.getStackTrace());
				} catch (IOException e1) {
					System.out.println("Error writting errors...");
					e1.printStackTrace();
				}
				
				needsHelp = true;
			}
		}
	}

}
