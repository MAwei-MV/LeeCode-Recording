package LiKouPractice;

public class Pro31 {

	public static void main(String args[]) {
		Pro31 p = new Pro31();
		int a[] = { 3, 2, 1 };
		p.nextPermutation(a);
	}

	public void nextPermutation(int[] nums) {
		int i = nums.length - 1;
		int j = 0;
		g: for (; i >= 0; i--) {
			if (i - 1 >= 0 && nums[i - 1] < nums[i]) {
				for (j = i; j <= nums.length - 1; j++) {
					if (nums[j] <= nums[i - 1]) {
						break g;
					}
				}
				break g;
			}
		}
		if (i == -1)
			i++;
		else {
			j--;
			int temp = nums[i - 1];
			nums[i - 1] = nums[j];
			nums[j] = temp;
		}

		for (int m = i; m <= i + (nums.length - 1 - i) / 2; m++) {
			int temp1 = nums[m];
			nums[m] = nums[nums.length - m + i - 1];
			nums[nums.length - m + i - 1] = temp1;
		}
	}
}
