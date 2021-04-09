package SpecialCode;

public class SlidingWindow {
	//灵魂方法：GetKSubArray()
	/*
	 * 固定窗口大小情况：固定初始化左右指针l和r； 1.l初始化为0； 2.初始r，使得r-l-1等于窗口大小； 3.同时移动l和r
	 * 4.判断窗口内的连续元素是否满足题目限定的条件； 4.1如果满足，再判断是否需要更新最优解，如果需要则更新 4.2如果不满足，则继续
	 */
	/*
	 * 可变窗口情况，固定初始化左右指针l和r； 1.l和r都初始化为0； 2.r指针移动一步； 3.判断窗口内的连续元素是否满足题目限定条件
	 * 3.1如果满足，再判断是否需要更新最优解，如果需要则更新最优解，并尝试 通过移动l指针缩小窗口大小，继续执行3.1 3.2如果不满足，则继续；
	 * 形象的说，就是r指针不听向右移动，l指针仅仅在窗口满足条件之后才会移动， 起到窗口收缩的效果
	 */

	// 求数组n的前i项和:pre[𝑖]=pre[𝑖−1]+nums[𝑖]
	public int[] GetProNums(int nums[]) {
		int[] pre = new int[nums.length];
		pre[0] = nums[0];
		for (int i = 1; i < pre.length; i++) {
			pre[i] = pre[i - 1] + nums[i];
		}
		return pre;
	}

	// 求一个数组的连续子数组总个数
	public int GetSumSubArray(int nums[]) {
		int sum = 0;
		int pre = 0;
		for (int i = 0; i < nums.length; i++) {
			pre += 1;
			sum += pre;
		}
		return sum;
	}

	// 求一个数组相邻差为 1 连续子数组的总个数:下标差为1时值差也为1
	public int Get1SubArray(int nums[]) {
		if (nums.length == 0 || nums.length == 1)
			return 0;
		int sum = 0;
		int pre = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] - nums[i - 1] == 1)
				pre++;
			else
				pre = 0;
			sum += pre;
		}
		return sum;
	}

	// 不大于 k 的子数组的个数(重点 掌握，灵魂方法)
	public int GetKSubArray(int nums[], int k) {
		if (nums.length == 0)
			return 0;
		int pre = 0;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] <= k)
				pre++;
			else
				pre = 0;
			sum += pre;
		}
		return sum;
	}

	// 求最大值刚好是 k 的子数组的个数;
	public int MaxValueK(int nums[], int k) {
		return GetKSubArray(nums, k) - GetKSubArray(nums, k - 1);
	}

	// 求子数组最大值刚好是 介于 k1 和 k2 的子数组的个数
	public int BetweenKValue(int nums[], int k1, int k2) {
		return GetKSubArray(nums, k2) - GetKSubArray(nums, k1 - 1);
	}
	// 对应力扣209,467,904,795,992,1109
}
