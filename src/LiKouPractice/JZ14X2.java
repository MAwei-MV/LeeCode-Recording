package LiKouPractice;

public class JZ14X2 {
	public static void main(String args[]) {
		JZ14X2 j = new JZ14X2();
		System.out.println(j.cuttingRope(120));
	}

	// 长度为n剪成m段，乘积最大为
	/*
	 * 这题不能DP，因为数很大时不能已经超出比较大小的范围，取余后更不能比较大小 public int cuttingRope(int n) { int m =
	 * n; // 总长度为n的绳子分成m段的最大长度 int res[][] = new int[n + 1][m + 1]; for (int i = 1;
	 * i < n + 1; i++) { // 不管多长，m=1时最大乘积为n值 res[i][1] = i; // n长度分n段，乘积为1 res[i][i]
	 * = 1; } // 开始填表 for (int i = 2; i < n + 1; i++) { for (int j = 2; j < i; j++)
	 * { for (int k = 2; i - k > 0; k++) res[i][j] = Math.max(res[i][j], res[i -
	 * k][j - 1] * k); } } int max = 0; for (int i = 1; i < m + 1; i++) { max =
	 * Math.max(res[n][i], max); } return max; }
	 */
	//根据数学公式得，尽量将n值切割为多个3时，所得乘积最大
	public int cuttingRope(int n) {
		if (n < 4) {
			return n - 1;
		} else if (n == 4) {
			return n;
		}
		long res = 1;
		while (n > 4) {
			res *= 3;
			res %= 1000000007;
			n -= 3;
		}
		return (int) (res * n % 1000000007);
	}
}