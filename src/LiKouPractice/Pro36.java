package LiKouPractice;

import java.util.HashMap;

public class Pro36 {
	public boolean isValidSudoku(char[][] board) {
		HashMap<Integer, Integer> raw[] = new HashMap[9];
		HashMap<Integer, Integer>[] col = new HashMap[9];
		HashMap<Integer, Integer>[] box = new HashMap[9];
		for (int i = 0; i < 9; i++) {
			raw[i] = new HashMap<Integer, Integer>();
			col[i] = new HashMap<Integer, Integer>();
			box[i] = new HashMap<Integer, Integer>();
		}
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					int n = board[i][j] - '0';
					int box1 = (i / 3) * 3 + j / 3;
					raw[i].put(n, raw[i].getOrDefault(n, 0) + 1);
					col[j].put(n, col[j].getOrDefault(n, 0) + 1);
					box[box1].put(n, box[box1].getOrDefault(n, 0) + 1);
					if (raw[i].get(n) == 2 || col[j].get(n) == 2 || box[box1].get(n) == 2) {
						return false;
					}
				}
			}
		}
		return true;
	}
}
