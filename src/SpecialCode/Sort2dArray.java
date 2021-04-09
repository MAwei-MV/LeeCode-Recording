package SpecialCode;

import java.util.Arrays;
import java.util.Comparator;

public class Sort2dArray {
	public static void main(String args[]) {
		int a[][] = { { 1, 3, 2 }, { 2, 4, 5 }, { 5, 5, 8 }, { 0, 3, 1 }, { 6, 6, 4 }, { 7, 1, 2 }, { 3, 3, 2 } };
		Arrays.sort(a, new Comparator<int[]>() {
			//按照二维数组的第一个元素升序排列，如果第一个元素相等，再按照第二个元素升序排列
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0])
					return o1[1] - o2[1];
				return o1[0] - o2[0];
			}
		});
		System.out.println(a);
	}
}
