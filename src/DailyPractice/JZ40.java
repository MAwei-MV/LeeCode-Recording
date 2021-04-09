package DailyPractice;

import java.util.HashMap;

//位运算:<<1表示二进制左移一位，>>1表示右移一位； &表示与运算 ；
public class JZ40 {
	public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
		int index = 1;
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum ^= array[i];
		}
		// 求出第一个“1”点
		while ((index & sum) == 0) {
			index = index << 1;
		}
		int result1 = 0;
		int result2 = 0;
		for (int i = 0; i < array.length; i++) {
			if ((index & array[i]) == 0) {
				result1 ^= array[i];
			} else {
				result2 ^= array[i];
			}
		}
		num1[0] = result1;
		num2[0] = result2;
	}
	/*
	public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i = 0; i < array.length; i++) {
			if (hm.containsKey(array[i])) {
				hm.put(array[i], 2);
			} else {
				hm.put(array[i], 1);
			}
		}
		int value = 0;
		for (int i = 0; i < array.length; i++) {
			if (hm.get(array[i]) == 1) {
				if (value == 0) {
					num1[0] = array[i];
					value++;
				}
				num2[0] = array[i];
			}
		}
	}
	*/
}
