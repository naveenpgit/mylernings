package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/valid-sudoku/
public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		Map<Integer, Boolean> rowMap = new HashMap<>();// already validated to Row tracker;
		Map<Integer, Boolean> colMap = new HashMap<>();// already validated to Column tracker;

		int rowStart = 0;
		int colStart = 0;
		while (rowStart < 9) {
			while (colStart < 9) {
				boolean isBoxValid = isBoxValid(board, rowStart, colStart);

				boolean isRowValid = rowMap.get(rowStart) == null ? isRowValid(board, rowStart) : rowMap.get(rowStart);
				boolean isColumnValid = colMap.get(colStart) == null ? isColumnValid(board, colStart) : colMap.get(colStart);

				boolean isValid = isBoxValid && isRowValid && isColumnValid;
				if (!isValid)
					return false;

				if (isRowValid)
					rowMap.put(rowStart, isRowValid);

				if (isColumnValid)
					colMap.put(colStart, isColumnValid);

				colStart += 3;
			}
			rowStart += 3;
			colStart = 0;
		}
		return true;
	}

	boolean isRowValid(char[][] board, int row) {
		for (int rowStart = row; rowStart < row + 3; rowStart++) {
			Set<Character> temp = new HashSet<>();
			for (int col = 0; col < 9; col++) {
				boolean unique = temp.add(board[rowStart][col]);
				if ('.' != board[rowStart][col] && !unique)
					return false;
			}
		}
		return true;
	}

	boolean isColumnValid(char[][] board, int col) {
		Set<Character> temp = new HashSet<>();
		for (int row = 0; row < 9; row++) {
			boolean unique = temp.add(board[row][col]);
			if ('.' != board[row][col] && !unique)
				return false;
		}
		return true;
	}

	boolean isBoxValid(char[][] board, int row, int col) {
		Set<Character> temp = new HashSet<>();
		for (int rowStart = row; rowStart < row + 3; rowStart++) {
			for (int colStart = col; colStart < col + 3; colStart++) {
				boolean unique = temp.add(board[rowStart][colStart]);
				if ('.' != board[rowStart][colStart] && !unique)
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		ValidSudoku validSudoku = new ValidSudoku();

		System.out.println(validSudoku.isValidSudoku(
				new char[][] {
						{ '7', '.', '.', '.', '4', '.', '.', '.', '.' },
						{ '.', '.', '.', '8', '6', '5', '.', '.', '.' },
						{ '.', '1', '.', '2', '.', '.', '.', '.', '.' },
						{ '.', '.', '.', '.', '.', '9', '.', '.', '.' },
						{ '.', '.', '.', '.', '5', '.', '5', '.', '.' },
						{ '.', '.', '.', '.', '.', '.', '.', '.', '.' },
						{ '.', '.', '.', '.', '.', '.', '2', '.', '.' },
						{ '.', '.', '.', '.', '.', '.', '.', '.', '.' },
						{ '.', '.', '.', '.', '.', '.', '.', '.', '.' } }));

	}
}
