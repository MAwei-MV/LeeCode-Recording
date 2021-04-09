package LiKouPractice;

public class Pro674 {
	public int findLengthOfLCIS(int[] nums) {
		int N = nums.length;
		if (N <= 1)
			return N;
		int res = 1;
		int i = 1;
		int flag = 1;
		while (i < nums.length) {
			if (nums[i] - nums[i - 1] > 0) {
				flag++;
			} else {
				res = Math.max(res, flag);
				flag=1;
			}
		}
		return res;
	}
}
