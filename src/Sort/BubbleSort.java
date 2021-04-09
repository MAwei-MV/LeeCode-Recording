package Sort;

public class BubbleSort {
	public static void main(String args[]) {
		int a[] = new int[] { 7, 2, 1, 2, 8, 3, 4, 0, 31, 11 };
		int res[] = bubble(a);
		for (int index : res) {
			System.out.println(index);
		}
	}
	//冒泡排序中添加标志位flag可以让最好情况的时间复杂度变为O(n)
	private static int[] bubble(int[] arr) {
		int len = arr.length;
		boolean flag=false;
		for (int i = 0; i < len; i++) {
			flag=false;
			for (int j = 0; j < len - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					flag=true;
				}
			}
			if(!flag) {
				break;
			}
		}
		return arr;
	}
}
