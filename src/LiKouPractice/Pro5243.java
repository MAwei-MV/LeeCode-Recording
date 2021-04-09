package LiKouPractice;

import java.util.Arrays;

public class Pro5243 {
	public int tupleSameProduct(int[] nums) {
		int N = nums.length;
		Arrays.sort(nums);
		int[][] NUMs = new int[N][N];
		/*
		 * for (int i = 0; i < N; i++) { for (int j = i + 1; j < N; j++) { NUMs[i][j] =
		 * nums[i] * nums[j]; } }
		 */
		for (int end = 3; end < nums.length; end++) {
			helper(end, nums);
		}
		return count * 8;
	}

	private int count = 0;

	private void helper(int end, int[] nums) {
		for (int i = 0; i <= end - 3; i++) {
			int flag = nums[i] * nums[end];
			int s = i + 1;
			int t = end - 1;
			while (s < t) {
				if (nums[s] * nums[t] < flag) {
					s++;
				} else if (nums[s] * nums[t] > flag) {
					t--;
				} else {
					count++;
					t--;
					s++;
				}
			}
			/*
			 * for (int j = i + 1; j <= end - 2; j++) { for (int k = end - 1; k > j; k--) {
			 * if (NUMs[j][k] == flag) count++; } }
			 */
		}
	}
}
