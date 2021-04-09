package LiKouPractice;

public class Pro73 {
	public void setZeroes(int[][] matrix) {
		boolean raw = false;
		boolean col = false;
		// 第一行和第一列作为标记位。首先记录第一行和第一列是否含0
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				col = true;
				break;
			}
		}
		for (int j = 0; j < matrix[0].length; j++) {
			if (matrix[0][j] == 0) {
				raw = true;
				break;
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}
		for (int i = 1; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				for (int k = 0; k < matrix[0].length; k++) {
					matrix[i][k] = 0;
				}
			}
		}
		for (int j = 1; j < matrix[0].length; j++) {
			if (matrix[0][j] == 0) {
				for (int k = 0; k < matrix.length; k++) {
					matrix[k][j] = 0;
				}
			}
		}
		if (raw) {
			for (int k = 0; k < matrix[0].length; k++) {
				matrix[0][k] = 0;
			}
		}
		if (col) {
			for (int k = 0; k < matrix.length; k++) {
				matrix[k][0] = 0;
			}
		}
	}
}
