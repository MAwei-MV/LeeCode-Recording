package DailyPractice;

import java.util.Arrays;

public class JZ30 {
	public static void main(String args[]) {
		int[] a = new int[] { 1, -2, 3, -4, -5, 6 };
		JZ30 j = new JZ30();
		System.out.print(j.FindGreatestSumOfSubArray(a));
	}

	public int FindGreatestSumOfSubArray(int[] array) {
		int[] dp = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			if (i == 0) {
				dp[i] = array[i];
			} else {
				dp[i] = array[i] > dp[i - 1] + array[i] ? array[i] : dp[i - 1] + array[i];
			}
		}
		Arrays.sort(dp);
		return dp[dp.length - 1];
	}
}
