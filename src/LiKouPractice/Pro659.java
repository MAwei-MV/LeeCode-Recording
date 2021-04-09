package LiKouPractice;

public class Pro659 {
	public boolean isPossible(int[] nums) {
		int n = nums.length;
		int dp1 = 0; // ����Ϊ1����������Ŀ
		int dp2 = 0; // ����Ϊ2����������Ŀ
		int dp3 = 0; // ����>=3����������Ŀ
		int idx = 0;

		while (idx < n) {
			int start = idx;
			int x = nums[idx];
			while (idx < n && nums[idx] == x) {
				idx++;
			}
			int cnt = idx - start; // �����е�ǰ�����ĸ���Ϊcnt

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