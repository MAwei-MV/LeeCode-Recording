package LiKouPractice;

public class Pro494 {
	public static void main(String atgs[]) {
		Pro494 pro494 = new Pro494();
		int a[] = { 0,0,0,0,0,0,0,0,1 };
		System.out.println(pro494.findTargetSumWays(a, 1));
	}

	// DP
	public int findTargetSumWays(int[] nums, int S) {
		int N = nums.length;
		if (N == 0)
			return 0;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += nums[i];
		}
		if (S > sum || S < -sum)
			return 0;
		// 结果范围为[-sum,sum]，分别对应[0,2*sum];对应规则：nums[i]+sum
		int res[][] = new int[2 * sum + 1][N];
		res[nums[0] + sum][0] += 1;
		res[-nums[0] + sum][0] += 1;
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 2 * sum + 1; j++) {
				if (res[j][i - 1] >= 1) {
					res[j + nums[i]][i] += res[j][i - 1];
					res[j - nums[i]][i] += res[j][i - 1];
				}
			}
		}
		return res[S + sum][N - 1];
	}
}
