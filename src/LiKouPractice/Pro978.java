package LiKouPractice;

public class Pro978 {
	public static void main(String args[]) {
		Pro978 p = new Pro978();
		int[] a = { 170, 59, 129, 54, 5, 98, 129, 37, 58, 193 };
		System.out.println(p.maxTurbulenceSize(a));
	}

	/*
	 * public int maxTurbulenceSize(int[] A) { // result[i]表示前i个数的最大湍流子数组 int[]
	 * result = new int[A.length + 1]; if (A.length == 1) return 1; if (A.length ==
	 * 2) return (A[0] == A[1] ? 1 : 2); for (int i = 0; i <= 1; i++) { result[i] =
	 * i; } result[2] = (A[0] == A[1] ? 1 : 2); for (int i = 3; i <= A.length; i++)
	 * { result[i] = Math.max(result[i - 1], cal(A, i)); } return result[A.length];
	 * }
	 * 
	 * public int cal(int[] A, int index) { int sum = 1; int flag = 0; for (int i =
	 * index; i >= 2; i--) { if (i > 1 && A[i - 1] > A[i - 2]) { flag++; } else if
	 * (i > 1 && A[i - 1] < A[i - 2]) { flag--; } else if (i > 1 && A[i - 1] == A[i
	 * - 2]) { return sum; } if (flag != (A[index - 1] - A[index - 2] > 0 ? 1 : -1)
	 * && flag != 0) { return sum; } sum++; } return sum; }
	 */
	public int maxTurbulenceSize(int[] A) {
		int N = A.length;
		int ans = 1;
		int anchor = 0;
		for (int i = 1; i < N; ++i) {
			int c = Integer.compare(A[i - 1], A[i]);
			if (i == N - 1 || c * Integer.compare(A[i], A[i + 1]) != -1) {
				if (c != 0)
					ans = Math.max(ans, i - anchor + 1);
				anchor = i;
			}
		}
		return ans;
	}
}
