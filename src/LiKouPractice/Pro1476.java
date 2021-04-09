package LiKouPractice;

public class Pro1476 {
	private int[][] rec = null;

	public Pro1476(int[][] rectangle) {
		this.rec = rectangle;
	}

	public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
		int row = rec.length;
		int col = rec[0].length;
		if (row1 < 0 || col1 < 0 || row2 < 0 || col2 < 0 || row1 >= row || col1 >= col)
			return;
		for (int i = row1; i <= (row2 < row ? row2 : row - 1); i++) {
			for (int j = col1; j <= (col2 < col ? col2 : col - 1); j++) {
				rec[i][j] = newValue;
			}
		}
	}

	public int getValue(int row, int col) {
		return rec[row][col];
	}
}
