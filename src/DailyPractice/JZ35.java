package DailyPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JZ35 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		str = str.substring(1, str.length() - 1);
		String[] valueArr = str.split(",");
		int[] array = new int[valueArr.length];
		for (int i = 0; i < valueArr.length; i++) {
			array[i] = Integer.parseInt(valueArr[i]);
		}
		System.out.println(InversePairs(array));
	}

	public static int InversePairs(int[] array) {
		if (array == null)
			return 0;
		int[] tmp = new int[array.length];
		return mergeSort(array, tmp, 0, array.length - 1);
	}

	// πÈ≤¢≈≈–Ú£¨µ›πÈ
	private static int mergeSort(int[] array, int[] tmp, int low, int high) {
		if (low >= high)
			return 0;
		int res = 0, mid = low + (high - low) / 2;
		res += mergeSort(array, tmp, low, mid);
		res += mergeSort(array, tmp, mid + 1, high);
		res += merge(array, tmp, low, mid, high);
		res %= 1000000007;
		return res;
	}

	// πÈ≤¢≈≈–Ú£¨∫œ≤¢
	private static int merge(int[] array, int[] tmp, int low, int mid, int high) {
		int i1 = low, i2 = mid + 1, k = low;
		int res = 0;
		while (i1 <= mid && i2 <= high) {
			if (array[i1] > array[i2]) {
				res += mid - i1 + 1;
				res %= 1000000007;
				tmp[k++] = array[i2++];
			} else
				tmp[k++] = array[i1++];
		}
		while (i1 <= mid)
			tmp[k++] = array[i1++];
		while (i2 <= high)
			tmp[k++] = array[i2++];
		for (int i = low; i <= high; i++)
			array[i] = tmp[i];
		return res;
	}
}