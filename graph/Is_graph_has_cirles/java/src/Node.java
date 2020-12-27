import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Node {
	private String mName;
	private List<Node> mNeighbours = new ArrayList<Node>();
	public String getmName() {
		return mName;
	}
	public void setName(String mName) {
		this.mName = mName;
	}
	public List<Node> getNeighbours() {
		return mNeighbours;
	}
	public void addNeighbour(Node mNeighbour) {
		this.mNeighbours.add(mNeighbour);
	}
	@Override
	public String toString() {
		return "{" + mName + ", " + Arrays.toString(getNeighboursNamesArray()) + "}";
	}
	private String[] getNeighboursNamesArray() {
		String[] names = new String[mNeighbours.size()];
		for(int i = 0; i < names.length; i++){
			names[i] = mNeighbours.get(i).getmName();
		}
		return names;
	}
	
	
}
