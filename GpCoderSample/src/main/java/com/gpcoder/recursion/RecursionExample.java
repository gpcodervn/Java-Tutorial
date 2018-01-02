package com.gpcoder.recursion;

public class RecursionExample {
	public static final char QUEEN_SIGN = 'Q';
	public static final char BLANK_SIGN = '-';
	public static final int N = 8;

	// Set a board with all Blank
	public static void setboardBlank(char board[][]) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = BLANK_SIGN;
			}
		}
	}

	// Print a board to screen
	public static void printboard(char board[][]) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}

	// Check Queen if at postion [RowIndex][ColumIndex] is Safe or not
	public static boolean isQueenSafeAtPosition(char board[][], int RowIndex, int ColumnIndex) {
		//Check safe at Row and Column
		for (int i = 0; i < N; i++) {
			if (board[RowIndex][i] == QUEEN_SIGN) {
				return false;
			}
	 
			if (board[i][ColumnIndex] == QUEEN_SIGN) {
				return false;
			}
		}
	 
		//Check safe at first diagonal
		for (int i = RowIndex, j = ColumnIndex; (i >= 0) && (j >= 0); i--, j--) {
			if (board[i][j] == QUEEN_SIGN) {
				return false;
			}
		}
	 
		for (int i = RowIndex, j = ColumnIndex; (i < N) && (j < N); i++, j++) {
			if (board[i][j] == QUEEN_SIGN) {
				return false;
			}
		}
	 
		//Check safe at second diagonal
		for (int i = RowIndex, j = ColumnIndex; (i >= 0) && (j < N); i--, j++) {
			if (board[i][j] == QUEEN_SIGN) {
				return false;
			}
		}
	 
		for (int i = RowIndex, j = ColumnIndex; (i < N) && (j >= 0); i++, j--) {
			if (board[i][j] == QUEEN_SIGN) {
				return false;
			}
		}
	 
		return true;
	}

	// Solve N-Queen Problem, Backtracking here!
	public static boolean solveNQueenProblem(char board[][], int RowIndex) {
		if (RowIndex >= N) {
			return true;
		}
	 
		for (int j = 0; j < N; j++) {
			if (isQueenSafeAtPosition(board, RowIndex, j) == true) {
				board[RowIndex][j] = QUEEN_SIGN;
				if (solveNQueenProblem(board, RowIndex + 1) == true) {
					return true;
				} else {
					board[RowIndex][j] = BLANK_SIGN;
				}
			}
		}
	 
		return false;
	}

	public static void main(String[] args) {
		char board[][] = new char[N][N];
		 
		setboardBlank(board);
	 
		if (solveNQueenProblem(board, 0) == false) {
			System.out.println("Can't find any solution!");
		} else {
			printboard(board);
		}
	}

}
