package graph;

// JAVA program to print all 
// paths from a source to 
// destination. 
import java.util.ArrayList;
import java.util.List;

// A directed graph using 
// adjacency list representation 
public class PrintAllPathFromS2DGraph {

	int vertix = 0;

	ArrayList<Integer>[] adjList;

	// Constructor
	public PrintAllPathFromS2DGraph(int vertices) {
		vertix = vertices;
		initAdjList();

	}

	// utility method to initialise
	// adjacency list
	@SuppressWarnings("unchecked")
	private void initAdjList() {

		adjList = new ArrayList[vertix];

		for (int i = 0; i < vertix; i++) {
			adjList[i] = new ArrayList<>();
		}
	}

	// add edge from u to v
	public void addEdge(int u, int v) {
		adjList[u].add(v);
	}

	// Prints all paths from
	// 's' to 'd'
	public void printAllPaths(int s, int d) {

		boolean isVisted[] = new boolean[vertix];

		List<Integer> pathList = new ArrayList<>();
		pathList.add(s);

		printAllPathsUtil(s, d, isVisted, pathList);
	}

	// A recursive function to print
	// all paths from 'u' to 'd'.
	// isVisited[] keeps track of
	// vertices in current path.
	// localPathList<> stores actual
	// vertices in the current path
	private void printAllPathsUtil(Integer u, Integer d, boolean[] isVisited, List<Integer> localPathList) {

		isVisited[u] = true;

		if (u.equals(d)) {
			System.out.println(localPathList);
			isVisited[u] = false;
			return;
		}

		for (Integer i : adjList[u]) {

			if (!isVisited[i]) {
				localPathList.add(i);

				printAllPathsUtil(i, d, isVisited, localPathList);
				localPathList.remove(i);
			}

		}

		isVisited[u] = false;

	}

	// Driver program
	public static void main(String[] args) {
		// Create a sample graph
		PrintAllPathFromS2DGraph g = new PrintAllPathFromS2DGraph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 3);
		g.addEdge(0, 2);
		g.addEdge(2, 1);
		g.addEdge(2, 0);
		g.addEdge(1, 3);

		// arbitrary source
		int s = 2;

		// arbitrary destination
		int d = 3;

		System.out.println("Following are all different paths from " + s + " to " + d);
		g.printAllPaths(s, d);

	}
}

// This code is contributed by Himanshu Shekhar.
