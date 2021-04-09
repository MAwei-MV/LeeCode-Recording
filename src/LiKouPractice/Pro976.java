package LiKouPractice;

import java.util.Arrays;

public class Pro976 {
	public int largestPerimeter(int[] A) {
		Arrays.sort(A);
		if (A.length < 3)
			return 0;
		int flag = A.length - 1;
		while (flag >= 0) {
			if (flag - 2 >= 0 && A[flag - 2] + A[flag - 1] > A[flag]) {
				return A[flag - 2] + A[flag - 1] + A[flag];
			}
			flag--;
		}
		return 0;
	}
}
