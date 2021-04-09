package LiKouPractice;

public class Pro1314 {
	public static void main(String args[]) {
		int a[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		Pro1314 p = new Pro1314();
		System.out.println(p.matrixBlockSum(a, 1));
	}

	public int[][] matrixBlockSum(int[][] mat, int K) {
		// 构造前缀和数组PreSum
		int m = mat.length;
		int n = mat[0].length;
		int res[][] = new int[m][n];
		int[][] preSum = new int[m + 1][n + 1];
		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + mat[i - 1][j - 1];
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int startX = i - K <= 0 ? 0 : i - K ;
				int startY = j - K  <= 0 ? 0 : j - K ;
				int endX = i + K + 1 >= m ? m : i + K + 1;
				int endY = j + K + 1 >= n ? n : j + K + 1;
				res[i][j] = preSum[endX][endY] - preSum[startX][endY] - preSum[endX][startY] + preSum[startX][startY];
			}
		}
		return res;
	}
}