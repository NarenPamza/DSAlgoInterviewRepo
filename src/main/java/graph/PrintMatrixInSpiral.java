package graph;

/**
 * Ref: https://leetcode.com/problems/spiral-matrix-ii/ Given a positive integer
 * n, generate a square matrix filled with elements from 1 to n2 in spiral
 * order.
 * 
 * Example:
 * 
 * Input: 3 Output: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]
 *
 */
public class PrintMatrixInSpiral {

	public static void main(String[] args) {
		int n = 2;
		generateMatrix(n);
	}

	public static int[][] generateMatrix(int n) {
		int topToRightSIndex = 0;
		int topToBottomStartIndex = n - 1;
		int bottomToLeftStartIndex = n - 1;
		int bottomToTopStartIndex = 0;
		int[][] board = new int[n][n];

		fillSpiral(board, topToRightSIndex, topToBottomStartIndex, bottomToLeftStartIndex, bottomToTopStartIndex, n, 1,
				n * n);

		printBoard(board);
		return board;
	}

	private static void printBoard(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void fillSpiral(int[][] board, int topToRightSIndex, int topToBottomStartIndex,
			int bottomToLeftStartIndex, int bottomToTopStartIndex, int n, int startValue, int endValue) {
		while (endValue >= startValue) {
			// Top to Right
			for (int i = 0, j = topToRightSIndex; i < n; i++) {
				if (board[j][i] == 0) {
					board[j][i] = startValue++;
				}
			}

			if (startValue > endValue) {
				break;
			}

			// Top to Bottom
			for (int i = 0, j = topToBottomStartIndex; i < n; i++) {
				if (board[i][j] == 0)
					board[i][j] = startValue++;
			}

			if (startValue > endValue) {
				break;
			}

			// bottom to left
			for (int i = bottomToLeftStartIndex, j = n - 1; j >= 0; j--) {
				if (board[i][j] == 0)
					board[i][j] = startValue++;
			}

			if (startValue > endValue) {
				break;
			}

			// Bottom to top
			for (int j = bottomToTopStartIndex, i = n - 1; i >= 0; i--) {
				if (board[i][j] == 0) {
					board[i][j] = startValue++;
				}
			}

			if (startValue > endValue) {
				break;
			}
			n = n - 1;
			topToRightSIndex = topToRightSIndex + 1;
			topToBottomStartIndex = topToBottomStartIndex - 1;
			bottomToLeftStartIndex = bottomToLeftStartIndex - 1;
			bottomToTopStartIndex = bottomToTopStartIndex + 1;
		}
	}
}