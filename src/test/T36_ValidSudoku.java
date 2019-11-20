package test;

public class T36_ValidSudoku {

	public static void main(String[] args) {
		char Sudoku1[][] = { 
				{ '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '.', '5', '.', '.', '.' },
				{ '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' },
				{ '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' },
				{ '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' },
				{ '.', '.', '.', '.', '8', '.', '.', '7', '9' } 
			};
		System.out.println(isValidSudoku(Sudoku1));
	}

	public static boolean isValidSudoku(char[][] board) {
		boolean row[][] = new boolean[9][9];
		boolean col[][] = new boolean[9][9];
		boolean box[][] = new boolean[9][9];
		int num, boxIndex;
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board.length; j++)
				if (board[i][j] != '.') {
					num = board[i][j] - '0' - 1;
					boxIndex = i / 3 * 3 + j / 3; // --> KEYPOINT
					if (row[i][num] || col[j][num] || box[boxIndex][num]) {
						return false;
					} else {
						row[i][num] = true;
						col[j][num] = true;
						box[boxIndex][num] = true;
					}
				}
		return true;
	}

}
