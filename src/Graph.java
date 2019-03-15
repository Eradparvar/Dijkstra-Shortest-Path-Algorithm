import java.util.Comparator;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Graph {

	private Set<Node> nodes = new HashSet<>();

	public void addNode(Node nodeA) {
		nodes.add(nodeA);

	}

	public Optional<Node> getNode(String nodeName) {

		return nodes.stream().filter(n -> n.getNodeName().equals(nodeName)).findFirst();

	}

	public void printGraph() {
		nodes.stream().sorted(Comparator.comparing(Node::getDistance)).forEach(System.out::println);

	}
}