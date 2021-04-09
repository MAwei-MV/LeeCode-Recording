package LiKouPractice;

public class Pro1641 {
	public int countVowelStrings(int n) {
		// 定义dp[n][5]数组，其中dp[i][0-4]表示
		// 长度为i的以a-u结尾的字符串的个数，递推关系见代码
		int[][] dp = new int[n + 1][5];
		// 初始化n=1的情况
		for (int i = 0; i < 5; i++) {
			dp[1][i] = 1;
		}

		for (int i = 2; i <= n; i++) {
			dp[i][0] = dp[i - 1][0];
			for (int j = 1; j < 5; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
			// 长度i的以u结尾的字符串可以由任意一个长度i-1的字符串结尾加个u得到
			/*
			 * dp[i][4] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3] + dp[i -
			 * 1][4]; dp[i][3] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3];
			 * dp[i][2] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]; dp[i][1] = dp[i -
			 * 1][0] + dp[i - 1][1]; dp[i][0] = dp[i - 1][0];
			 */
		}

		// 最终答案求个和就行啦
		return dp[n][0] + dp[n][1] + dp[n][2] + dp[n][3] + dp[n][4];
	}
}