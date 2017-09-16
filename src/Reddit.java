import java.util.ArrayList;

public class Reddit {
	private String kind = "";
	private Data data = null;
	private ArrayList<Children> children = new ArrayList<>();
	
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
	public ArrayList<Children> getChildren() {
		return children;
	}
	public void setChildren(ArrayList<Children> children) {
		this.children = children;
	}
}
