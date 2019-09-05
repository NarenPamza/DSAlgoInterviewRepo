package dp;
/*
  You can stick this driver function in a class and run the code below
*/
public class SubMatrixSumSolution {

	public static void main(String args[]) {

		int matrix[][] = { { 6, -5, -7, 4, -4 }, { -9, 3, -6, 5, 2 }, { -10, 4, 7, -6, 3 }, { -8, 9, -3, 3, -7 } };

		Rectangle maxSumRectangle = maxSum(matrix);

		System.out.println("Rectangle Sum: " + maxSumRectangle.interiorSum);

		System.out.println("Left Index: " + maxSumRectangle.leftBorderIndex);
		System.out.println("Right Index: " + maxSumRectangle.rightBorderIndex);
		System.out.println("Top Index: " + maxSumRectangle.topBorderIndex);
		System.out.println("Bottom Index: " + maxSumRectangle.bottomBorderIndex);
	}

	private static Rectangle maxSum(int matrix[][]) {
		int rows = matrix.length;
		int cols = matrix[0].length;

		Rectangle maxRectangle = new Rectangle();

		for (int left = 0; left < cols; left++) {

			int runningRowSums[] = new int[rows];
			for (int right = left; right < cols; right++) {

				for (int i = 0; i < rows; i++) {
					runningRowSums[i] += matrix[i][right];
				}

				KadaneResult kadaneResult = kadane(runningRowSums);

				if (kadaneResult.maxSum > maxRectangle.interiorSum) {

					/*
					 * Set a new interiorSum for our maxRectangle
					 */
					maxRectangle.interiorSum = kadaneResult.maxSum;
					maxRectangle.leftBorderIndex = left;
					maxRectangle.rightBorderIndex = right;
					maxRectangle.topBorderIndex = kadaneResult.startIndex;
					maxRectangle.bottomBorderIndex = kadaneResult.endIndex;
				}
			}
		}

		return maxRectangle;
	}

	private static KadaneResult kadane(int arr[]) {
		int bestMaxSoFar = 0;

		int maxRegionStart = -1;
		int maxRegionEnd = -1;

		int currentStart = 0;
		int bestMaxAtThisIndex = 0;

		for (int i = 0; i < arr.length; i++) {

			bestMaxAtThisIndex += arr[i];

			if (bestMaxAtThisIndex < 0) {
				bestMaxAtThisIndex = 0;
				currentStart = i + 1;
			}

			if (bestMaxAtThisIndex > bestMaxSoFar) {
				maxRegionStart = currentStart;
				maxRegionEnd = i;
				bestMaxSoFar = bestMaxAtThisIndex;
			}

		}

		return new KadaneResult(bestMaxSoFar, maxRegionStart, maxRegionEnd);
	}
}

/*
 * Holds the result of running Kadan's algorithm maxSum: the actual sum of the
 * Max Contiguous Subarray Sum region startIndex: start of Max Contiguous
 * Subarray Sum region endIndex: end of Max Contiguous Subarray Sum region
 */
class KadaneResult {

	int maxSum;
	int startIndex;
	int endIndex;

	public KadaneResult(int maxSum, int startIndex, int endIndex) {
		this.maxSum = maxSum;
		this.startIndex = startIndex;
		this.endIndex = endIndex;
	}

}

/*
 * A rectangle with left, right, top, and bottom bounds. The sum of all items
 * contained within the rectangle are also recorded in the 'interiorSum'
 * variable.
 */
class Rectangle {

	int interiorSum;

	int leftBorderIndex;
	int rightBorderIndex;
	int topBorderIndex;
	int bottomBorderIndex;
}
