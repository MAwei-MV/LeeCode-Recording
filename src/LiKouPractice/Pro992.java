package LiKouPractice;

import java.util.HashMap;

public class Pro992 {
	public static void main(String args[]) {
		int a[] = { 1, 2, 1, 2, 3 };
		Pro992 p = new Pro992();
		System.out.println(p.subarraysWithDistinct(a, 2));
	}
	// 超时，
	/*
	 * public int subarraysWithDistinct(int[] A, int K) { return atMostK(A, K) -
	 * atMostK(A, K - 1); }
	 * 
	 * private int atMostK(int[] A, int k) { int j = 0; int i = 0; int p = 0; int
	 * sum = 0; HashMap<Integer, Integer> hm = new HashMap<>(); while (j < A.length)
	 * { if (hm.containsKey(A[j])) { hm.replace(A[j], hm.get(A[j]) + 1); p++; } else
	 * { hm.put(A[j], 1); if (hm.size() > k) { int value = 0; while
	 * (!hm.containsValue(0)) { hm.replace(A[i], hm.get(A[i]) - 1); value = A[i];
	 * i++; p--; } hm.remove(value); } p++; } j++; sum += p; } return sum; }
	 */

	/*
	 * public int subarraysWithDistinct(int[] A, int K) { int left1 = 0, left2 = 0;
	 * int sum = 0; Windows window1 = new Windows(); Windows window2 = new
	 * Windows(); for (int right = 0; right < A.length; right++) {
	 * window1.addElement(A[right]); window2.addElement(A[right]); while
	 * (window1.getDIfferent() > K) { window1.shrink(A[left1]); left1++; } while
	 * (window2.getDIfferent() >= K) { window2.shrink(A[left2]); left2++; } sum +=
	 * (left2 - left1); } return sum; } }
	 * 
	 * class Windows { private HashMap<Integer, Integer> hm = new HashMap<>();
	 * private int different = 0;
	 * 
	 * public int getDIfferent() { return hm.size(); }
	 * 
	 * public void addElement(int x) { hm.put(x, hm.getOrDefault(x, 0) + 1); if
	 * (hm.get(x) == 1) different++; }
	 * 
	 * public void shrink(int x) { hm.put(x, hm.get(x) - 1); if (hm.get(x) == 0) {
	 * hm.remove(x); different--; } }
	 */
	// 方法一改进
	public int subarraysWithDistinct(int[] A, int K) {
		int left1 = 0;
		int left2 = 0;
		int sum = 0;
		int j = 0;
		HashMap<Integer, Integer> hm1 = new HashMap<>();
		HashMap<Integer, Integer> hm2 = new HashMap<>();
		while (j < A.length) {
			hm1.put(A[j], hm1.getOrDefault(A[j], 0) + 1);
			hm2.put(A[j], hm2.getOrDefault(A[j], 0) + 1);
			while (hm1.size() > K) {
				hm1.replace(A[left1], hm1.get(A[left1]) - 1);
				if (hm1.get(A[left1]) == 0)
					hm1.remove(A[left1]);
				left1++;
			}
			while (hm2.size() >= K) {
				hm2.replace(A[left2], hm2.get(A[left2]) - 1);
				if (hm2.get(A[left2]) == 0)
					hm2.remove(A[left2]);
				left2++;
			}
			j++;
			sum += (left2 - left1);
		}
		return sum;
	}

}
