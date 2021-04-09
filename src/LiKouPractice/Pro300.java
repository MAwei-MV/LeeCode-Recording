package LiKouPractice;

import java.util.Arrays;

public class Pro300 {
	public static void main(String args[]) {
		Pro300 p = new Pro300();
		int[] a = { 1, 3, 6, 7, 9, 4, 10, 5, 6 };
		System.out.println(p.lengthOfLIS(a));
	}

	public int lengthOfLIS(int[] nums) {
		if (nums.length == 0 || nums == null)
			return 0;
		// sum[x]表示前x个数的最长子序列
		int sum[] = new int[nums.length];
		sum[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				sum[i] = Math.max(nums[i] > nums[j] ? sum[j] + 1 : 1, sum[i]);
			}
		}
		Arrays.sort(sum);
		return sum[sum.length-1];
	}
}
