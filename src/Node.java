
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Node {
	private String nodeName;
	private List<Node> shortestPathList = new LinkedList<>();
	private int distance = Integer.MAX_VALUE;// distance from source
	Map<Node, Integer> adjacentNodes = new HashMap<>();

	public void addAdjacentNodes(Node adjacentNode, int distance) {
		adjacentNodes.put(adjacentNode, distance);
	}

	public String getNodeName() {
		return nodeName;
	}

	public Node(String NodeName) {
		this.nodeName = NodeName;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getDistance() {
		return distance;
	}

	public List<Node> getShortestPathList() {
		return shortestPathList;
	}

	public void setShortestPathList(List<Node> shortestPathList) {
		this.shortestPathList = shortestPathList;
	}

	public Map<Node, Integer> getAdjacentNodes() {
		return adjacentNodes;
	}

	@Override
	public String toString() {
		return nodeName + " " + distance;
	}
}
