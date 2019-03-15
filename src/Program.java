import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws FileNotFoundException {
//		Uncomment to use inputfile.txt
//		File file = new File("inputFile.txt");
//		Scanner scanner = new Scanner(file);
		Scanner scanner = new Scanner(System.in);
		Graph graph = new Graph();
		String vertexID1 = null, vertexID2;
		int weight;
		String[] userInput;

		System.out.println("Start");
		System.out.println("Enter in the form of <VertexID1>, <VertexID2>, <Weight> or -1 to quit");
		while (scanner.hasNext()) {

			userInput = scanner.nextLine().split("\\s");
			if (userInput[0].equals("-1")) {
				break;
			}
			vertexID1 = userInput[0];
			vertexID2 = userInput[1];
			weight = Integer.parseInt(userInput[2]);

			if (weight < 0) {
				System.out.println("No negative weights");
				continue;
			}

			Node v1 = graph.getNode(vertexID1).orElse(new Node(vertexID1));
			Node v2 = graph.getNode(vertexID2).orElse(new Node(vertexID2));

			v1.addAdjacentNodes(v2, weight);
			v2.addAdjacentNodes(v1, weight);
			graph.addNode(v1);
			graph.addNode(v2);

		}
		System.out.println("Enter starting node name");
		String startingNode = scanner.nextLine();
		DijkstraShortestPathAlgorithm dijkstraShortestPathAlgorithm = new DijkstraShortestPathAlgorithm(graph);
		dijkstraShortestPathAlgorithm.run(graph.getNode(startingNode).get());
		graph.printGraph();
		System.out.println("Done");

	}

}
