package Sort;

public class ShellSortIndirect {
	/*
	 * 希尔排序是把序列按下标的一定增量分组，对每组使用直接插入排序算法排序； 随着增量的逐渐减少，
	 * 每组包含的关键词越来越多，当增量减至1时，整个序列恰好被分为一组，算法便终止。
	 */
	public static void shellSort(int[] arr) {
		// 空数组 或 只有一个元素的数组，则什么都不做。
		if (arr == null || arr.length <= 1)
			return;
		// 定义希尔增量。
		int gap = arr.length / 2;
		// gap缩小到0的时候就退出循环。
		while (gap != 0) {
			// 每组进行直接插入排序。
			for (int i = gap; i < arr.length; i++) {// i 代表待插入元素的索引。
				int value = arr[i];
				int j = i - gap; // j 代表i的上一个元素，相差一个增量gap。
				// j < 0 时退出循环，说明 j 是最小的元素的索引值。
				// 或者 arr[j] <= value 时退出循环，说明 j 是比value小的元素的索引值。
				for (; j >= 0 && arr[j] > value; j -= gap) {
					arr[j + gap] = arr[j]; // 把元素往后挪。
				}
				System.out.println(j);
				arr[j + gap] = value;
			}
			// 把每一趟排序的结果也输出一下。
			print(arr);
			// 缩小增量。
			gap /= 2;
		}
	}

	public static void print(int[] arr) {
		if (arr == null)
			return;

		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void main(String args[]) {
		int a[] = { 9, 3, 1, 6, 2, 4, 0, 8, 7, 5 };
		shellSort(a);
	}
}