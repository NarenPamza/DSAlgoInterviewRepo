package dpDfsBackTracking;

/**
 * https://www.geeksforgeeks.org/maximum-sum-rectangle-in-a-2d-matrix-dp-27/
 * @author Admin
 *
 */
public class SubMatrixSum {

	static int maxSum = 0;
	static int topLeft = 0;
	static int topRight = 0;
	static int bottomLeft = 0;
	static int bottomRight = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		findMaxSubMatrix(
				new int[][] { { 1, 2, -1, -4, -20 }, { -8, -3, 4, 2, 1 }, { 3, 8, 10, 1, 3 }, { -4, -1, 1, 7, -6 } });
	}

	private static void findMaxSubMatrix(int[][] grid) {
		int cols = grid[0].length;
		int rows = grid.length;

		for (int left = 0; left < cols; left++) {

			int[] tmp = new int[rows];
			for (int right = left; right < cols; right++) {
				for (int i = 0; i < tmp.length; i++) {
					tmp[i] += grid[i][right];
				}

				int[] currentResult = kadane(tmp);

				if (currentResult[0] > maxSum) {
					maxSum = currentResult[0];
					topLeft = left;
					topRight = right;
					bottomLeft = currentResult[1];
					bottomRight = currentResult[2];
				}
			}
		}

		System.out.println("Max Sum is " + maxSum + " Range is (" + topLeft + " , " + bottomLeft + " )");
		System.out.println("( " + topRight + " , " + bottomRight + " ) ");
	}

	private static int[] kadane(int[] tmp) {

		int[] tmpResult = new int[3];
		int localStart = 0;

		int tmpSum = 0;
		for (int i = 0; i < tmp.length; i++) {
			tmpSum = Math.max(0, tmpSum += tmp[i]);
			if (tmpSum < 0) {
				tmpSum = 0;
				localStart = i + 1;
			} else if (tmpSum > tmpResult[0]) {
				tmpResult[0] = tmpSum;
				tmpResult[1] = localStart;
				tmpResult[2] = i;
			}
		}
		return tmpResult;
	}
}
