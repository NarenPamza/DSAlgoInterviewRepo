package graph;

/**
 * https://www.geeksforgeeks.org/count-possible-paths-top-left-bottom-right-nxm-matrix/
 */
class CountNumberOfWaysinMXNMAtrix {

	// Returns count of possible paths to reach
	// cell at row number m and column number n
	// from the topmost leftmost cell (cell at 1, 1)
	static int numberOfPaths(int m, int n) {
		// If either given row number is first or
		// given column number is first
		if (m == 1 || n == 1)
			return 1;

		// If diagonal movements are allowed then
		// the last addition is required.
		return numberOfPaths(m - 1, n) + numberOfPaths(m, n - 1);
		// + numberOfPaths(m-1, n-1);
	}

	public static void main(String args[]) {
		System.out.println(numberOfPaths(3, 3));
	}
}