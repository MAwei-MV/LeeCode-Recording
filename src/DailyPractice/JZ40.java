package DailyPractice;

import java.util.HashMap;

//λ����:<<1��ʾ����������һλ��>>1��ʾ����һλ�� &��ʾ������ ��
public class JZ40 {
	public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
		int index = 1;
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum ^= array[i];
		}
		// �����һ����1����
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
