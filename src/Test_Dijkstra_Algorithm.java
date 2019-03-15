import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

class Test_Dijkstra_Algorithm {
	Graph graph = new Graph();

	@Test
	public void test() {

		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D");
		Node nodeE = new Node("E");
		Node nodeF = new Node("F");

		nodeA.addAdjacentNodes(nodeB, 10);
		nodeA.addAdjacentNodes(nodeC, 15);

		nodeB.addAdjacentNodes(nodeD, 12);
		nodeB.addAdjacentNodes(nodeF, 15);

		nodeC.addAdjacentNodes(nodeE, 10);

		nodeD.addAdjacentNodes(nodeE, 2);
		nodeD.addAdjacentNodes(nodeF, 1);

		nodeF.addAdjacentNodes(nodeE, 5);

		graph.addNode(nodeA);
		graph.addNode(nodeB);
		graph.addNode(nodeC);
		graph.addNode(nodeD);
		graph.addNode(nodeE);
		graph.addNode(nodeF);
		DijkstraShortestPathAlgorithm algorithm = new DijkstraShortestPathAlgorithm(graph);
		graph = algorithm.run(nodeA);

		assertEquals("node a", 0, graph.getNode("A").get().getDistance());
		assertEquals("node b", 10, graph.getNode("B").get().getDistance());
		assertEquals("node c", 15, graph.getNode("C").get().getDistance());
		assertEquals("node d", 22, graph.getNode("D").get().getDistance());
		assertEquals("node e", 24, graph.getNode("E").get().getDistance());
		assertEquals("node f", 23, graph.getNode("F").get().getDistance());

	}
}
