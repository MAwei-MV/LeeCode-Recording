package SpecialCode;

import java.util.Arrays;
import java.util.Comparator;

public class Sort2dArray {
	public static void main(String args[]) {
		int a[][] = { { 1, 3, 2 }, { 2, 4, 5 }, { 5, 5, 8 }, { 0, 3, 1 }, { 6, 6, 4 }, { 7, 1, 2 }, { 3, 3, 2 } };
		Arrays.sort(a, new Comparator<int[]>() {
			//���ն�ά����ĵ�һ��Ԫ���������У������һ��Ԫ����ȣ��ٰ��յڶ���Ԫ����������
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0])
					return o1[1] - o2[1];
				return o1[0] - o2[0];
			}
		});
		System.out.println(a);
	}
}
