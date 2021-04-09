package LiKouPractice;

public class Pro650 {
	public static void main(String args[]) {
		Pro650 p = new Pro650();
		System.out.println(p.minSteps(5));
	}

	public int minSteps(int n) {
		// res[i][j]=m表示打印出i个，复制的是j个，最少的操作数,i>j必成立
		int[][] res = new int[n + 1][n + 1];
		if (n == 1)
			return 0;
		if (n <= 4)
			return n;
		res[2][1] = 2;
		res[3][1] = 3;
		for (int i = 4; i < res.length; i++) {
			for (int j = 1; j < i; j++) {
				if (i % 2 == 0 && i / 2 == j) {
					if (res[i - j][j] != 0) {
						res[i][j] = Math.min(res[i - j][j] + 1, getMin(res[j]) + 2);
					} else
						res[i][j] = getMin(res[j]) + 2;
				}
				if (res[i - j][j] != 0)
					res[i][j] = res[i - j][j] + 1;
			}
		}
		return getMin(res[n]);
	}

	private int getMin(int a[]) {
		int temp = Integer.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > 0 && a[i] < temp)
				temp = a[i];
		}
		return temp;
	}
}
