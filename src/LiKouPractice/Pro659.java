package LiKouPractice;

public class Pro659 {
	public boolean isPossible(int[] nums) {
		int n = nums.length;
		int dp1 = 0; // 长度为1的子序列数目
		int dp2 = 0; // 长度为2的子序列数目
		int dp3 = 0; // 长度>=3的子序列数目
		int idx = 0;

		while (idx < n) {
			int start = idx;
			int x = nums[idx];
			while (idx < n && nums[idx] == x) {
				idx++;
			}
			int cnt = idx - start; // 数组中当前整数的个数为cnt

			if (start > 0 && x != nums[start - 1] + 1) {
				if (dp1 + dp2 > 0) {
					return false;
				} else {
					dp1 = cnt;
					dp2 = dp3 = 0;
				}
			} else {
				if (dp1 + dp2 > cnt) {
					return false;
				}
				int left = cnt - dp1 - dp2;
				int keep = Math.min(dp3, left);
				dp3 = keep + dp2;
				dp2 = dp1;
				dp1 = left - keep;
			}
		}

		return dp1 == 0 && dp2 == 0;
	}
}