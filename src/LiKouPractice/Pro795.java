package LiKouPractice;

public class Pro795 {
	// 如果一道题可以用暴力解决出来，而且题目恰好有连续的限制，那么滑动窗口的前缀和就应该被想到
	public static void main(String args[]) {
		Pro795 p = new Pro795();
		int a[] = { 2, 1, 4, 3 };
		System.out.println(p.numSubarrayBoundedMax(a, 2, 3));
	}

	// 蛮力解法，未用前缀和
	/*
	 * public int numSubarrayBoundedMax(int[] A, int L, int R) { if (A.length == 0)
	 * return 0; int[] dp = new int[A.length + 1]; int flag = -1; if (A[0] >= L &&
	 * A[0] <= R) dp[1] = 1; else if (A[0] > R) { flag = 0; } for (int i = 2; i <=
	 * A.length; i++) { if (A[i - 1] > R) { dp[i] = dp[i - 1]; flag = i - 1; } else
	 * if (A[i - 1] >= L && A[i - 1] <= R) { dp[i] = dp[i - 1] + i - 1 - flag; }
	 * else { int x = flag; for (int j = i - 2; j > flag; j--) { if (A[j] >= L &&
	 * A[j] <= R) { x = j; break; } } dp[i] = dp[i - 1] + x - flag; } } return
	 * dp[A.length]; }
	 */
	// 前缀和解法：
	public int numSubarrayBoundedMax(int[] A, int L, int R) {
		return helper(A, R) - helper(A, L - 1);
	}

	private int helper(int[] a, int index) {
		int pre = 0;
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] <= index)
				pre++;
			else
				pre = 0;
			sum += pre;
		}
		return sum;
	}

}
