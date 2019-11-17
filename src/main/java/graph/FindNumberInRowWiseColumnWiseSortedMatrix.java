package graph;

/**
 * https://www.geeksforgeeks.org/search-in-row-wise-and-column-wise-sorted-matrix/
 * 
 *
 */
public class FindNumberInRowWiseColumnWiseSortedMatrix {

	public static void main(String[] args) {

		int[][] board = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 } };

		int x = 35;
		System.out.println(findNumberInBoard(board, x));
	}

	private static boolean findNumberInBoard(int[][] board, int x) {
		boolean result = false;

		int n = board[0].length;

		int i = 0;
		int j = n - 1;

		// check for index out of Bound
		while (i < n && j >= 0) {

			if (board[i][j] == x) {
				return true;

			} else if (board[i][j] > x) // Omit entire Column
			{
				j--;
			} else if (board[i][j] < x) {
				i++;
			}
		}
		return result;
	}
}
