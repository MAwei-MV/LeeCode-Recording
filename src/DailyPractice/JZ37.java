package DailyPractice;

public class JZ37 {
	// ¶ş·Ö²éÕÒ
	public int GetNumberOfK(int[] array, int k) {
		if (array.length == 0)
			return 0;
		int l = 0, r = array.length - 1;
		int mid;
		while (l < r) {
			mid = (r - l) / 2;
			if (array[l + mid] >= k) {
				r = l + mid;
			} else {
				l = l + mid + 1;
			}
		}
		int left = l;
		l = 0;
		r = array.length - 1;
		while (l < r) {
			mid = (r - l) / 2;
			if (array[l + mid] <= k) {
				l = l + mid + 1;
			} else {
				r = l + mid;
			}
		}
		int right = l;
		if (array[l] == k)
			++right;
		return right - left;
	}
}
