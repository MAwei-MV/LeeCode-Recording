package LiKouPractice;

import java.util.Arrays;

public class Pro5639 {
	public int minimumTimeRequired(int[] jobs, int k) {
		return 0;
		/*
		 * if (k >= jobs.length) { Arrays.sort(jobs); return jobs[jobs.length - 1]; }
		 * int sum = 0; for (int i = 0; i < jobs.length; i++) { sum += jobs[i]; } int x
		 * = sum / k; int flag[] = new int[jobs.length]; int dp[][] = new int[k][x];
		 * for(int m=0;m<k) for (int i = 0; i < jobs.length; i++) { for (int j =
		 * jobs[i]; j <= x; j++) { if (flag[i] == 0&&dp[i][j - jobs[j]] +
		 * jobs[j]>dp[i][j]) { flag[i]=1; dp[i][j]=dp[i][j - jobs[j]] + jobs[j]; } } }
		 */
	}
}
