package LiKouPractice;

public class Pro283 {
	public static void main(String args[]) {
		int[] a = { 0, 1, 0, 3, 12 };
		Pro283 p = new Pro283();
		p.moveZeroes(a);
	}

	public void moveZeroes(int[] nums) {
		int m = 0, n = 0;
		for (; n < nums.length; n++) {
			if (nums[n] != 0 && m == n) {
				m++;
			} else if (nums[n] != 0 && m != n) {
				int temp = nums[m];
				nums[m] = nums[n];
				nums[n] = temp;
				m++;
			}
		}

	}
}
