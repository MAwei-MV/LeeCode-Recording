package Sort;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
	// Ͱ����:
	// ÿ��Ͱ�ĳ���Ϊ(max(arr)-min(arr))/(len(arr)-1);ע��Ͱ������Ϊ1
	// Ͱ������=((max(arr)-min(arr))/ÿ��Ͱ�ĳ���) +1;
	// ȷ��ÿ������Ӧ��Ͱ��location=(arr[i]-min(arr))/ÿ��Ͱ�ĳ���
	public static void bucketSort(int[] arr) {

		// �������ֵ����Сֵ
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]);
		}

		// ����Ͱ������
		int bucketLen = (max - min) / (arr.length - 1);
		int bucketNum = (max - min) / bucketLen + 1;
		ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
		for (int i = 0; i < bucketNum; i++) {
			bucketArr.add(new ArrayList<Integer>());
		}

		// ��ÿ��Ԫ�ط���Ͱ
		for (int i = 0; i < arr.length; i++) {
			int num = (arr[i] - min) / bucketLen;
			bucketArr.get(num).add(arr[i]);
		}

		// ��ÿ��Ͱ��������
		for (int i = 0; i < bucketArr.size(); i++) {
			Collections.sort(bucketArr.get(i));
		}

		// ��Ͱ�е�Ԫ�ظ�ֵ��ԭ����
		int index = 0;
		for (int i = 0; i < bucketArr.size(); i++) {
			for (int j = 0; j < bucketArr.get(i).size(); j++) {
				arr[index++] = bucketArr.get(i).get(j);
			}
		}
	}
}
