import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

public class DijkstraShortestPathAlgorithm {

	private Graph graph;
	private Set<Node> visitedNodes = new HashSet<>();
	private Set<Node> unVisitedNodes = new HashSet<>();
	private Node currentNode;

	public DijkstraShortestPathAlgorithm(Graph newGraph) {
		graph = newGraph;
	}

	public Graph run(Node source) {

		source.setDistance(0);

		unVisitedNodes.add(source);

		while (unVisitedNodes.size() != 0) {
			currentNode = getLowestDistanceNode(unVisitedNodes);
			unVisitedNodes.remove(currentNode);
			for (Entry<Node, Integer> entry : currentNode.getAdjacentNodes().entrySet()) {
				Node adjacentNode = entry.getKey();
				Integer edgeWeigh = entry.getValue();

				if (!visitedNodes.contains(adjacentNode)) {
					CalculateMinimumDistance(adjacentNode, edgeWeigh, currentNode);
					unVisitedNodes.add(adjacentNode);
				}
			}
			visitedNodes.add(currentNode);
		}
		return graph;
	}

	private void CalculateMinimumDistance(Node evaluationNode, Integer edgeWeigh, Node sourceNode) {
		Integer sourceDistance = sourceNode.getDistance();
		if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
			evaluationNode.setDistance(sourceDistance + edgeWeigh);
			LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPathList());
			shortestPath.add(sourceNode);
			evaluationNode.setShortestPathList(shortestPath);
		}
	}

	private Node getLowestDistanceNode(Set<Node> unVisitedNodes) {
		Node lowestDistanceNode = null;
		int lowestDistance = Integer.MAX_VALUE;
		for (Node node : unVisitedNodes) {
			int nodeDistance = node.getDistance();
			if (nodeDistance < lowestDistance) {
				lowestDistance = nodeDistance;
				lowestDistanceNode = node;
			}
		}
		return lowestDistanceNode;
	}

//	private void print() {
//		System.out.println("The sourceNode is " + sourceNode.getId());
//		for (Entry<Integer, Node> entry : graph.getNodes().entrySet()) {
//
//			System.out.println("The shortest path for" + entry.getValue());
//
//			System.out.println(entry.getValue().getAlgoInfo().getShortestDistVertexVia());
//		}
//	}

}
