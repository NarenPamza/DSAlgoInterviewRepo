package graph;

public class IslandInGrid {

	public static void main(String[] args) {

		int[][] board = new int[][] { { 1, 1, 0, 0, 1 }, 
									  { 1, 1, 0, 0, 0 }, 
									  { 0, 0, 1, 0, 0 }, 
									  { 0, 0, 0, 1, 1 } };

		System.out.println(findNumberOfIslands(board));
	}

	private static int findNumberOfIslands(int[][] board) {
		
		if(board == null || board.length == 0){
			return 0;
		}

		int numberOfIsland = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if(board[i][j] == 1){
					numberOfIsland += dfs(board, i, j);
				}
			}
		}

		return numberOfIsland;
	}

	private static int dfs(int[][] board, int i, int j) {
		if( i< 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == 0){
			return 0;
		}
		board[i][j]= 0;
		dfs(board,i+1, j);
		dfs(board, i-1, j);
		dfs(board, i, j+1);
		dfs(board, i, j-1);
		
		return 1;
	}

}
