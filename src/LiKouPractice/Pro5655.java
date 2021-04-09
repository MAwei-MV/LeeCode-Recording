package LiKouPractice;

import java.util.Arrays;

public class Pro5655 {
	public int largestSubmatrix(int[][] matrix) {
		int res = 0;
		int m = matrix.length;
		int n = matrix[0].length;
		for (int i = 1; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 1)
					matrix[i][j] += matrix[i - 1][j];
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			Arrays.sort(matrix[i]);
			for (int j = n - 1; j >= 0; j--) {
				res = Math.max((n - j) * matrix[i][j], res);
			}
		}
		return res;
	}
}