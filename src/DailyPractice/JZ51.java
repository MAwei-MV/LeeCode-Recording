package DailyPractice;

public class JZ51 {
	public int[] multiply(int[] A) {
		int[] B = new int[A.length];
		B[0] = 1;
		int x = 1;
		if (A.length == 1)
			return null;
		for (int i = 1; i < A.length; i++) {
			B[i] = B[i - 1] * A[i - 1];
		}
		for (int j = A.length - 1; j >= 0; j--) {
			B[j] = x * B[j];
			x *= A[j];
		}
		return B;
	}
}
