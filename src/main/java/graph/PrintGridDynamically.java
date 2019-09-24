package graph;

public class PrintGridDynamically {
	
	public static void main(String[] args) {
		
		char[][] board = new char[][] { 
			{ 'A', 'B', 'C', 'D', 'E' }, 
			{ 'F', 'G', 'H', 'I', 'J' }, 
			{ 'K', 'L', 'M', 'N', 'O' } ,
			{ 'P', 'Q', 'R', 'S', 'T' }
		};
		
		int rowLength = board[0].length -1;
		int columnLength = board.length -1;
		System.out.println(board[0][0]);
		
		for (int i = 1; i <= columnLength; i++) {
			printBoard(board, rowLength, i, 0);
		}
		
		for (int j = 1; j <= columnLength; j++) {
			printBoard(board, rowLength, columnLength, j);
		}
		
		System.out.println(board[columnLength][rowLength]);
	}

	private static void printBoard(char[][] board, int rowLength, int i, int j) {
		while(i >=0 && j <= rowLength){
			System.out.print( " " + board[i][j]);
			i--;
			j++;
		}
		System.out.println();
	}
}
