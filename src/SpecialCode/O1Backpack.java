package SpecialCode;

public class O1Backpack {
//01背包问题：给定一组数，如{2,3}表示价值为2，重量为3；
//同时给定一个整数表示背包容量，求所能装的最大价值的物品
	public static void main(String args[]) {
		int[][] a = { { 3, 2 }, { 4, 3 }, { 5, 4 }, { 6, 5 } };
		int w = 8;
		O1Backpack o = new O1Backpack();
		System.out.println(o.getMaxValue(a, w));
	}
	/*
	 * public int getMaxValue(int[][] t, int w) { // 1.朴素01背包解法： //
	 * dp[i][j]空闲容量为j、前i个物品，能装的最大价值。 /* int dp[][] = new int[t.length + 1][w + 1];
	 * for (int i = 1; i < dp.length; i++) { for (int j = 1; j < dp[0].length; j++)
	 * { if (j < t[i - 1][1]) { // 装不进 dp[i][j] = dp[i - 1][j]; } // 能装进 else {
	 * dp[i][j] = Math.max(dp[i - 1][j], t[i - 1][0] + dp[i - 1][j - t[i - 1][1]]);
	 * } } } return dp[dp.length - 1][w]; }
	 */

	public int getMaxValue(int[][] t, int w) { // 2.优化空间后的01背包
		int dp[] = new int[w + 1];
		for (int i = 0; i < t.length; i++) {
			for (int j = w; j >= t[i][1]; j--) {
				dp[j] = Math.max(dp[j], dp[j - t[i][1]] + t[i][0]);
			}
		}
		return dp[w];
	}

}
