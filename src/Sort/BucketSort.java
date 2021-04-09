package Sort;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
	// 桶排序:
	// 每个桶的长度为(max(arr)-min(arr))/(len(arr)-1);注意桶长至少为1
	// 桶的数量=((max(arr)-min(arr))/每个桶的长度) +1;
	// 确定每个数对应的桶：location=(arr[i]-min(arr))/每个桶的长度
	public static void bucketSort(int[] arr) {

		// 计算最大值与最小值
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]);
		}

		// 计算桶的数量
		int bucketLen = (max - min) / (arr.length - 1);
		int bucketNum = (max - min) / bucketLen + 1;
		ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
		for (int i = 0; i < bucketNum; i++) {
			bucketArr.add(new ArrayList<Integer>());
		}

		// 将每个元素放入桶
		for (int i = 0; i < arr.length; i++) {
			int num = (arr[i] - min) / bucketLen;
			bucketArr.get(num).add(arr[i]);
		}

		// 对每个桶进行排序
		for (int i = 0; i < bucketArr.size(); i++) {
			Collections.sort(bucketArr.get(i));
		}

		// 将桶中的元素赋值到原序列
		int index = 0;
		for (int i = 0; i < bucketArr.size(); i++) {
			for (int j = 0; j < bucketArr.get(i).size(); j++) {
				arr[index++] = bucketArr.get(i).get(j);
			}
		}
	}
}
