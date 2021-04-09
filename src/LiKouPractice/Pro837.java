package LiKouPractice;

public class Pro837 {
	/*
	 * public double new21Game(int N, int K, int W) { //
	 * �൱�ڼ���һֱ�����ȥ���ڽ��Ϊ[K,K+W-1]ʱ������[K,N]�ĸ��� if (W - 1 <= N) return 1; if (N < K)
	 * return 0; int result[] = new int[K + W - 1]; result[0] = 0; result[1] = 1;
	 * for (int i = 2; i < result.length; i++) { if (i <= W) result[i] += 1; for
	 * (int j = i - 1; j >= i / 2; j--) { result[i] += result[j] * result[i - j]; }
	 * }
	 * 
	 * }
	 */
	// dp[x]��ʾ��ֵΪx��ʱ���ʤ�ĸ��ʣ���˵�x<=min(N,K+W-1)&&x>=Kʱ��dp[x]=1;
	// ��x>=K&&x>min(N,K+W-1)ʱ����ʤ����Ϊ0����dp[x]=0;���ʣ���������
//������������ʵ�DP
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
