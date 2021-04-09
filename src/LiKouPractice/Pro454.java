package LiKouPractice;

import java.util.HashMap;

public class Pro454 {
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				hm.put(A[i] + B[j], hm.getOrDefault(A[i] + B[j], 0) + 1);
			}
		}
		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < D.length; j++) {
				int flag = -(C[i] + D[j]);
				if (hm.containsKey(flag)) {
					sum += hm.get(flag);
				}
			}
		}
		return sum;
	}

}
