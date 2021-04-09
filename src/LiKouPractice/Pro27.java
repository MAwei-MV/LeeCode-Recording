package LiKouPractice;

public class Pro27 {
	public static void main(String args[]) {
		Pro27 p =new Pro27();
		int a[]= {4,5};
		System.out.println(p.removeElement(a, 5));
	}
	public int removeElement(int[] nums, int val) {
		if (nums.length == 0)
			return 0;
		int flag = nums.length - 1;
		for (int i = 0; i <= flag; i++) {
			if (nums[i] == val) {
				while (flag>=0&&nums[flag] == val) {
					flag--;
				}
				if(flag<i) break;
				if(flag<=0) return 0;
				int temp = nums[i];
				nums[i] = nums[flag];
				nums[flag] = temp;
				flag--;
			}
		}
		return flag+1;
	}
}
