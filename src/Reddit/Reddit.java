package Reddit;
/*
 * Brandon Dalton, Christopher Turner
 * 09/16/2017
 * University of Southern California
 * Viterbi School of Engineering
 * Mass-IG
 * 
 * Reddit.java
 */

public class Reddit {
	private String kind = "";
	private Data data = null;
	
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
}
