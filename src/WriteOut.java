/*
 * Brandon Dalton
 * 09/16/2017
 * University of Southern California
 * Viterbi School of Engineering
 * Mass-IG
 * 
 * WriteOut.java
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class WriteOut {

	// Reddit -> void
	// Decomposes the reddit object input
	public static void writeData(Reddit reddit) {
		String types = "Number,Author,Title,View Count,Num Comments,Ups,Downs,Score,Text";
		ArrayList<Children> children = reddit.getData().getChildren();
		ArrayList<Data> allData = new ArrayList<>();
		
		//For each child from Reddit put all their data into an ArrayList
		for (Children c : children) {
			allData.add(c.getData());
		}
		
		//Write the data from the allData ArrayList to a CSV
		writeToCSV(allData, types);
		System.out.println("Write Complete see reddit.csv");
	}

	// String String -> void
	// Writes the data found in the data ArrayList to a CSV file
	private static void writeToCSV(ArrayList<Data> data, String header) {
		try {
			FileWriter fw = new FileWriter(new File("reddit.csv"));
			PrintWriter pw = new PrintWriter(fw);
			
			//Printing the header of the CSV
			pw.println(header);
			int counter = 0;
			
			//Traverse the Data ArrayList
			for (Data d : data) {
				//Getting all the data from the Data object
				String author = d.getAuthor(), title = d.getTitle(), viewC = d.getView_count(),
						numComments = d.getNum_comments(), ups = d.getUps(), downs = d.getDowns(), score = d.getScore(),
						text = d.getSelftext();
				
				//Printing all the data to the CSV
				pw.println("\"" + counter + "\",\"" + author + "\",\"" + title + "\",\"" + viewC + "\",\"" + numComments
						+ "\",\"" + ups + "\",\"" + downs + "\",\"" + score + "\",\"" + text + "\"");
				counter++;
			}
			pw.close();
			fw.close();

		} catch (IOException e) {
			System.out.println("Error writing the CSV file: " + e.getMessage());
		}
	}
}
