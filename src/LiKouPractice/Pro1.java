package LiKouPractice;

import java.util.HashMap;
import java.util.Map;

public class Pro1 {
	/*
	 * public int[] twoSum(int[] nums, int target) { int[] newNums = new
	 * int[nums.length]; for (int i = 0; i < nums.length; i++) { newNums[i] =
	 * nums[i]; } Arrays.sort(newNums); int[] a = new int[2]; int[] b = new int[2];
	 * int j = nums.length - 1; int i = 0; int k = 0; while (i <= j) { if
	 * (newNums[i] + newNums[j] == target) { a[0] = newNums[i]; a[1] = newNums[j];
	 * break; } else if (newNums[i] + newNums[j] < target) { i++; } else { j--; } }
	 * for (int m = 0; m < nums.length; m++) { if (nums[m] == a[0] || nums[m] ==
	 * a[1]) { b[k] = m; k++; } } return b; }
	 */
	//建立hash表，从数组中匹配变为从hash表中匹配，匹配时间变短
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; ++i) {
			if (hashtable.containsKey(target - nums[i])) {
				return new int[] { hashtable.get(target - nums[i]), i };
			}
			hashtable.put(nums[i], i);
		}
		return new int[0];
	}
}
