package org.sk.arraysAndHashing;

public class ValidateSudoku {

	public boolean isValidSudoku(char[][] board) {
		Grid[][] grid = new Grid[9][9];

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					int num = board[i][j] - '1';
					int boxIndex = (i / 3) * 3 + j / 3; 
					// boxIndex generates only below values  
					// 0 1 2
					// 3 4 5
					// 6 7 8
					// Eg: 0 denotes a grid(3 x 3) as below
					// board[0][0]  board[0][1]  board[0][2]
					// board[1][0]  board[1][1]  board[1][2]
					// board[2][0]  board[2][1]  board[2][2]

					grid[i][num] = grid[i][num] != null ? grid[i][num] : new Grid();
					grid[j][num] = grid[j][num] != null ? grid[j][num] : new Grid();
					grid[boxIndex][num] = grid[boxIndex][num] != null ? grid[boxIndex][num] : new Grid();

					if (grid[i][num].row || grid[j][num].col || grid[boxIndex][num].grid) {
						return false;
					}

					grid[i][num].row  = true;
					grid[j][num].col = true;
					grid[boxIndex][num].grid = true;
				}
			}
		}

		return true;
	}

	static class Grid {
		boolean row;
		boolean col;
		boolean grid;
	}

	public static void main(String[] args) {
		ValidateSudoku vs = new ValidateSudoku();
		char[][] board = { 
				{ '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, 
				{ '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, 
				{ '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, 
				{ '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, 
				{ '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		System.out.println(vs.isValidSudoku(board));
		board = new char[][] { 
				{ '.', '.', '.', '.', '5', '.', '.', '1', '.' },
				{ '.', '4', '.', '3', '.', '.', '.', '.', '.' }, 
				{ '.', '.', '.', '.', '.', '3', '.', '.', '1' },
				{ '8', '.', '.', '.', '.', '.', '.', '2', '.' }, 
				{ '.', '.', '2', '.', '7', '.', '.', '.', '.' },
				{ '.', '1', '5', '.', '.', '.', '.', '.', '.' },
				{ '.', '.', '.', '.', '.', '2', '.', '.', '.' },
				{ '.', '2', '.', '9', '.', '.', '.', '.', '.' }, 
				{ '.', '.', '4', '.', '.', '.', '.', '.', '.' } };
		System.out.println(vs.isValidSudoku(board));
	}

}