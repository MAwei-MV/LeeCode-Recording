package SpecialCode;

public class DpTest1 {
//在一个数组中找出一些不相邻的数，使他们的和最大
	public static void main(String args[]) {
		int x[] = { 1, 2, 4, 1, 7, 8, 3 ,99};
		System.out.println(MaxValue(x));
	}

	public static int MaxValue(int[] a) {
//迭代
//		int dp[] = new int[a.length];
//		for (int i = 0; i < a.length; i++) {
//			if (i == 0)
//				dp[i] = a[i];
//			else if (i == 1)
//				dp[i] = Math.max(a[0], a[1]);
//			else {
//				dp[i] = Math.max(dp[i - 1], a[i] + dp[i - 2]);
//			}
//		}
//		return dp[a.length - 1];

		return helper(a, a.length - 1);
	}
		//递归	
	private static int helper(int[] a, int index) {
		if (index == 0)
			return a[0];
		else if (index == 1)
			return Math.max(a[0], a[1]);
		else {
			return Math.max(helper(a, index - 1), a[index] + helper(a, index - 2));
		}
	}
}
