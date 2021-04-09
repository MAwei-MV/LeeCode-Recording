package LiKouPractice;

public class Pro209 {
	public static void main(String args[]) {
		int a[]= {2,3,1,2,4,3};
		Pro209 p =new Pro209();
		System.out.println(p.minSubArrayLen(7, a));
	}
	public int minSubArrayLen(int s, int[] nums) {
		if (nums.length == 0)
			return 0;
		int i = 0;
		int j = 0;
		int minLength = Integer.MAX_VALUE;
		int sum = 0;
		while (j < nums.length) {
			sum += nums[j];
			if (sum >= s) {
				while (i <= j) {
					sum -= nums[i];
					if (sum < s) {
						minLength = Math.min(minLength, j - i + 1);
						i++;
						break;
					}
					i++;
				}
			}
			j++;
		}
		if(minLength==Integer.MAX_VALUE) return 0;
		return minLength;
	}
}
