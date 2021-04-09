package Sort;

public class MergeSortIteration {
	public static void main(String args[]) {
		int[] test = new int[] { 6, 5, 3, 1, 8, 7, 2, 4 };
		MergeSortIteration m = new MergeSortIteration();
		System.out.print(m.merge_sort(test));
	}

	public int[] merge_sort(int[] arr) {
		int len = arr.length;
		int[] result = new int[len];
		int block, start;
		// ԭ�����ĵ�����������һ�Σ�û�п��ǵ���������������
		//block��ʾС������Ԫ�ظ���
		for (block = 1; block < len * 2; block *= 2) {
			for (start = 0; start < len; start += 2 * block) {
				int low = start;
				int mid = (start + block) < len ? (start + block) : len;
				int high = (start + 2 * block) < len ? (start + 2 * block) : len;
				// ���������ʼ�±꼰�����±�
				int start1 = low, end1 = mid;
				int start2 = mid, end2 = high;
				// ��ʼ������block���й鲢����
				while (start1 < end1 && start2 < end2) {
					result[low++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
				}
				while (start1 < end1) {
					result[low++] = arr[start1++];
				}
				while (start2 < end2) {
					result[low++] = arr[start2++];
				}
			}
			int[] temp = arr;
			arr = result;
			result = temp;
		}
		result = arr;
		return result;
	}
}
