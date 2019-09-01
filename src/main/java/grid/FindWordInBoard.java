package grid;

public class FindWordInBoard {

	public static void main(String[] args) {

		char[][] board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };

		String word = "ABCCED";
		System.out.println(findMatch(board, word));
	}

	private static boolean findMatch(char[][] board, String word) {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == word.charAt(0) && dfs(board, i, j, 0, word)) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean dfs(char[][] board, int i, int j, int k, String word) {

		if (k == word.length()) {
			return true;
		}

		if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != word.charAt(k)) {
			return false;
		}

		char tmp = board[i][j];
		board[j][j] = ' ';
		boolean found = dfs(board, i + 1, j, k + 1, word) || dfs(board, i - 1, j, k + 1, word)
				|| dfs(board, i, j + 1, k + 1, word) || dfs(board, i, j - 1, k + 1, word);
		board[i][j] = tmp;

		return found;
	}
}
