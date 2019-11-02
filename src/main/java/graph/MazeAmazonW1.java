package graph;

public class MazeAmazonW1 {

	static int count = 0;

	public static void main(String[] args) {
		char[][] board = new char[][] { 
										{ '&', '&', '&', 'S' }, 
										{ '#', '#', '#', '#' }, 
										{ '#', '&', '&', '&' },
										{ '#', '#', '#', '#' },
										{ '#', '&', '&', '#' },
										{ 'D', '#', '#', '#' } 
									  };

		boolean[][] isVisted = new boolean[board.length][board[0].length];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 'S') {
					dfs(board, i, j, isVisted);
				}
			}
		}

		System.out.println("Count is " + count);

	}

	private static boolean dfs(char[][] board, int i, int j, boolean[][] isVisted) {
		
		if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || isVisted[i][j] || board[i][j] == '&'){
			return false;
		}
		
		isVisted[i][j] = true;
		
		if (board[i][j] == 'D') {
			isVisted[i][j] = true;
			return true;
		}

		if (board[i][j] == '#') {
			isVisted[i][j] = true;
		}

		boolean result = dfs(board, i - 1, j, isVisted) || dfs(board, i + 1, j, isVisted)
				|| dfs(board, i, j - 1, isVisted) || dfs(board, i, j + 1, isVisted);

		if (result) {
			count = count + 1;
		}
		return result;
	}
}
