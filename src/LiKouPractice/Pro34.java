package LiKouPractice;

public class Pro34 {
	public int[] searchRange(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		int res[] = new int[] { -1, -1 };
		if (nums.length == 0)
			return res;
		while (low < high && nums[low] < target && nums[high] > target) {
			int mid = (low + high) / 2;
			if (nums[mid] < target)
				low = mid + 1;
			else
				high = mid;
		}
		int flag = 0;
		if (nums[high] == target)
			flag = high;
		else if (nums[low] == target)
			flag = low;
		else {
			return res;
		}
		int front = flag, after = flag;
		while (front >= 0 && nums[front] == target) {
			front--;
		}
		while (after < nums.length && nums[after] == target) {
			after++;
		}
		res[0] = ++front;
		res[1] = --after;
		return res;
	}
}
