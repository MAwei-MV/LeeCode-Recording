package LiKouPractice;

public class Pro922 {
	public static void main(String args[]) {
		Pro922 p = new Pro922();
		int a[] = { 648, 831, 560, 986, 192, 424, 997, 829, 897, 843 };
		System.out.println(p.sortArrayByParityII(a));
	}

	/*
	 * public int[] sortArrayByParityII(int[] A) { int flag[] = new int[A.length];
	 * for (int i = 0; i < A.length; i++) { if (flag[i] == 0 && i % 2 != A[i] % 2) {
	 * for (int j = i + 1; j < A.length; j++) { if (j % 2 != i % 2 && j % 2 != A[j]
	 * % 2) { int temp = A[i]; A[i] = A[j]; A[j] = temp; flag[j] = 1; break; } } } }
	 * return A; }
	 */
	public int[] sortArrayByParityII(int[] A) {
		int n = A.length;
		int j = 1;
		for (int i = 0; i < n; i += 2) {
			if (A[i] % 2 == 1) {
				while (A[j] % 2 == 1) {
					j += 2;
				}
				swap(A, i, j);
			}
		}
		return A;
	}

	public void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}
