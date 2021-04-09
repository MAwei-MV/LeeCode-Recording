package DailyPractice;

import java.util.Scanner;

public class JZ6 {
	public static void main(String args[]) {
		JZ6 j = new JZ6();
		Scanner sc = new Scanner(System.in);
		String initStr = sc.nextLine();
		String handleStr1 = initStr.substring(1, initStr.length() - 1);
		String[] handleStr2 = handleStr1.split(",");
		int[] handleStr3 = new int[handleStr2.length];
		for (int i = 0; i < handleStr2.length; i++) {
			handleStr3[i] = Integer.parseInt(handleStr2[i]);
		}
		System.out.println(j.minNumberInRotateArray(handleStr3));
	}

	public int minNumberInRotateArray(int[] array) {
		int size = array.length;
		int left = 0;
		int right = size - 1;
		int mid = size / 2;
		if (size == 0) {
			return 0;
		} else {
			while (mid != left && mid != right) {
				if (array[mid] < array[right]) {
					right = mid;
					mid = left + (right - left) / 2;
				} else if (array[mid] > array[right]) {
					left = mid;
					mid = left + (right - left) / 2;
				} else {
					right--;
					mid = left + (right - left) / 2;
				}
			}
			if (array[left] > array[right]) {
				mid=right;
			}
			return array[mid];
		}
	}
}
