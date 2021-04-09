package LiKouPractice;

public class Pro837 {
	/*
	 * public double new21Game(int N, int K, int W) { //
	 * 相当于计算一直相加下去，在结果为[K,K+W-1]时，落在[K,N]的概率 if (W - 1 <= N) return 1; if (N < K)
	 * return 0; int result[] = new int[K + W - 1]; result[0] = 0; result[1] = 1;
	 * for (int i = 2; i < result.length; i++) { if (i <= W) result[i] += 1; for
	 * (int j = i - 1; j >= i / 2; j--) { result[i] += result[j] * result[i - j]; }
	 * }
	 * 
	 * }
	 */
	// dp[x]表示在值为x的时候获胜的概率，因此当x<=min(N,K+W-1)&&x>=K时，dp[x]=1;
	// 当x>=K&&x>min(N,K+W-1)时，获胜概率为0，即dp[x]=0;精彩！！！！！
//我所见过的最精彩的DP
	public double new21Game(int N, int K, int W) {
		if (K == 0) {
			return 1.0;
		}
		double[] dp = new double[K + W];
		for (int i = K; i <= N && i < K + W; i++) {
			dp[i] = 1.0;
		}
		dp[K - 1] = 1.0 * Math.min(N - K + 1, W) / W;
		for (int i = K - 2; i >= 0; i--) {
			dp[i] = dp[i + 1] - (dp[i + W + 1] - dp[i + 1]) / W;
		}
		return dp[0];
	}
}
