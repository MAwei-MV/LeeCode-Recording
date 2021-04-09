package Sort;

public class ShellSortIndirect {
	/*
	 * ϣ�������ǰ����а��±��һ���������飬��ÿ��ʹ��ֱ�Ӳ��������㷨���� �����������𽥼��٣�
	 * ÿ������Ĺؼ���Խ��Խ�࣬����������1ʱ����������ǡ�ñ���Ϊһ�飬�㷨����ֹ��
	 */
	public static void shellSort(int[] arr) {
		// ������ �� ֻ��һ��Ԫ�ص����飬��ʲô��������
		if (arr == null || arr.length <= 1)
			return;
		// ����ϣ��������
		int gap = arr.length / 2;
		// gap��С��0��ʱ����˳�ѭ����
		while (gap != 0) {
			// ÿ�����ֱ�Ӳ�������
			for (int i = gap; i < arr.length; i++) {// i ���������Ԫ�ص�������
				int value = arr[i];
				int j = i - gap; // j ����i����һ��Ԫ�أ����һ������gap��
				// j < 0 ʱ�˳�ѭ����˵�� j ����С��Ԫ�ص�����ֵ��
				// ���� arr[j] <= value ʱ�˳�ѭ����˵�� j �Ǳ�valueС��Ԫ�ص�����ֵ��
				for (; j >= 0 && arr[j] > value; j -= gap) {
					arr[j + gap] = arr[j]; // ��Ԫ������Ų��
				}
				System.out.println(j);
				arr[j + gap] = value;
			}
			// ��ÿһ������Ľ��Ҳ���һ�¡�
			print(arr);
			// ��С������
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