package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/valid-sudoku/
public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		Map<String, Set<Character>> table = new HashMap<>();
		Map<String, Set<Character>> rows = new HashMap<>();
		Map<String, Set<Character>> cols = new HashMap<>();

		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {
				final char element = board[row][col];
				if (element == '.') {
					continue;
				}
				String grid = String.valueOf(row / 3) + String.valueOf(col / 3);
				if (table.getOrDefault(grid, new HashSet<>()).contains(element) ||
						rows.getOrDefault(String.valueOf(row), new HashSet<>()).contains(element) ||
						cols.getOrDefault(String.valueOf(col), new HashSet<>()).contains(element)) {
					return false;
				}
				Set<Character> temp = null;
				temp = table.getOrDefault(grid, new HashSet<>());
				temp.add(element);
				table.put(grid, temp);

				temp = rows.getOrDefault(String.valueOf(row), new HashSet<>());
				temp.add(element);
				rows.put(String.valueOf(row), temp);

				temp = cols.getOrDefault(String.valueOf(col), new HashSet<>());
				temp.add(element);
				cols.put(String.valueOf(col), temp);
			}
		}
		return true;
	}

	public static void main(String[] args) {
		ValidSudoku validSudoku = new ValidSudoku();
		char[][] input = new char[][] {
				{ '8', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' },
				{ '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' },
				{ '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' },
				{ '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' },
				{ '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		System.out.println(validSudoku.isValidSudoku(input));

	}
}
