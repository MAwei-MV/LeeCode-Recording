package LiKouPractice;

public class Pro376 {
	public int wiggleMaxLength(int[] nums) {
		if (nums.length <= 1)
			return nums.length;
		int flag = 0;
		int len = 1;
		for (int i = 1; i < nums.length; i++) {
			if ((nums[i] - nums[i - 1] > 0 && flag <= 0) || (nums[i] - nums[i - 1] < 0 && flag >= 0)) {
				len++;
				flag = nums[i] - nums[i - 1];
			}
		}
		return len;
	}
}
