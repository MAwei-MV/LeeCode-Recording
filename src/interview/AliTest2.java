package interview;

import java.util.Scanner;

public class AliTest2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		int index = 0;
		int count = 0;
		for (int i = 0; i < n; i++) {
			arr[index] = sc.nextInt();
			count += arr[index++];
		}
		AliTest2 aliTest2 = new AliTest2();
		System.out.print(aliTest2.helper(arr, 0, count));
	}

	// value表示已有的最大值，count表示该数组的总值
	//思想错误
	public int helper(int[] arr, int value, int count) {
		if (arr.length <= 1) {
			return value;
		}
		int index = 0;
		int val = 0;
		for (; index < arr.length; index++) {
			val += arr[index];
			if (val > count / 2) {
				break;
			}
		}
		if (count - val > val - arr[index]) {
			int arr1[] = new int[arr.length - index - 1];
			for (int i = 0; i < arr.length - index - 1; i++) {
				arr1[i] = arr[i + index + 1];
			}
			return helper(arr1, count - val + value, count - val);
		} else {
			int arr1[] = new int[index];
			for (int i = 0; i < index; i++) {
				arr1[i] = arr[i];
			}
			return helper(arr1, value + val - arr[index], val - arr[index]);
		}
	}
}
