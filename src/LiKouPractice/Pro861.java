package LiKouPractice;

public class Pro861 {
	public static void main(String args[]) {
		int a[][] = { { 0, 0, 1, 1 }, { 1, 0, 1, 0 }, { 1, 1, 0, 0 } };
		Pro861 p = new Pro861();
		System.out.println(p.matrixScore(a));
	}

	public int matrixScore(int[][] A) {
		int sum = (int) Math.pow(2, A[0].length - 1) * A.length;
		for (int i = 0; i < A.length; i++) {
			if (A[i][0] == 0) {
				for (int j = 0; j < A[0].length; j++) {
					A[i][j] = rolling(A[i][j]);
				}
			}
		}
		for (int i = 1; i < A[0].length; i++) {
			int temp0 = 0;
			int temp1 = 0;
			for (int j = 0; j < A.length; j++) {
				if (A[j][i] == 0)
					temp0++;
				else
					temp1++;
			}
			sum += (int) Math.pow(2, A[0].length - i - 1) * Math.max(temp0, temp1);
		}
		return sum;
	}

	private int rolling(int a) {
		if (a == 0)
			return 1;
		else
			return 0;
	}
}
