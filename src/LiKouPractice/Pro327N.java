package LiKouPractice;

public class Pro327N {
	public int countRangeSum(int[] nums, int lower, int upper) {
        long s = 0;
        long[] sum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; ++i) {
            s += nums[i];
            sum[i + 1] = s;
        }
        return countRangeSumRecursive(sum, lower, upper, 0, sum.length - 1);
    }

    public int countRangeSumRecursive(long[] sum, int lower, int upper, int left, int right) {
        if (left == right) {
            return 0;
        } else {
            int mid = (left + right) / 2;
            int n1 = countRangeSumRecursive(sum, lower, upper, left, mid);
            int n2 = countRangeSumRecursive(sum, lower, upper, mid + 1, right);
            int ret = n1 + n2;

            // 首先统计下标对的数量
            int i = left;
            int l = mid + 1;
            int r = mid + 1;
            while (i <= mid) {
                while (l <= right && sum[l] - sum[i] < lower) {
                    l++;
                }
                while (r <= right && sum[r] - sum[i] <= upper) {
                    r++;
                }
                ret += r - l;
                i++;
            }

            // 随后合并两个排序数组
            int[] sorted = new int[right - left + 1];
            int p1 = left, p2 = mid + 1;
            int p = 0;
            while (p1 <= mid || p2 <= right) {
                if (p1 > mid) {
                    sorted[p++] = (int) sum[p2++];
                } else if (p2 > right) {
                    sorted[p++] = (int) sum[p1++];
                } else {
                    if (sum[p1] < sum[p2]) {
                        sorted[p++] = (int) sum[p1++];
                    } else {
                        sorted[p++] = (int) sum[p2++];
                    }
                }
            }
            for (int j = 0; j < sorted.length; j++) {
                sum[left + j] = sorted[j];
            }
            return ret;
        }
    }

	public static void main(String arg[]) {
		int[] s = { 2147483647, -2147483648, -1, 0 };
		Pro327N p = new Pro327N();
		System.out.println(p.countRangeSum(s, -1, 1));
	}

/*自己做的时间复杂度不符合要求
 	int sum;
	public int countRangeSum(int[] nums, int lower, int upper) {
		int[][] x = new int[nums.length][nums.length];
		int i = 0;
		int j = 0;
		helper(nums, lower, upper, i, j, x, 0, 0, 1);
		return sum;
	}

	private void helper(int[] nums, int lower, int upper, int start, int end, int flag[][], long val, int extral,
			int g) {
		if (start < 0 || end < 0 || start > end || end >= nums.length || flag[start][end] == 1 || extral >= nums.length)
			return;
		val += Long.valueOf(g) * nums[extral];
		if (val <= upper && val >= lower)
			sum++;
		flag[start][end] = 1;
		helper(nums, lower, upper, start + 1, end, flag, val, start, -1);
		helper(nums, lower, upper, start, end + 1, flag, val, end + 1, 1);
	}
	*/
}
