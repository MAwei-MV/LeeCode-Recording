package SpecialCode;

public class DpTest2 {
//从一个数组中选取诺干个数，问是否能得到结果r。
	public static void main(String args[]) {
		DpTest2 dp = new DpTest2();
		int x[] = { 3,34, 4, 12, 5,2 };
		System.out.println(dp.ChooseNum(x, 9));
		System.out.println(dp.ChooseNum(x, 10));
		System.out.println(dp.ChooseNum(x, 11));
		System.out.println(dp.ChooseNum(x, 12));
		System.out.println(dp.ChooseNum(x, 13));
		
	}

	public boolean ChooseNum(int[] a, int r) {
		// 迭代
		boolean result[][] = new boolean[a.length][r + 1];
		for (int i = 0; i < a.length; i++) {
			result[i][0] = true;
		}
		if (a[0] <= r)
			result[0][a[0]] = true;
		for (int i = 1; i < a.length; i++) {
			for (int j = 1; j < r + 1; j++) {
				if (a[i] > j) {
					result[i][j] = result[i - 1][j];
				} else {
					result[i][j] = result[i - 1][j] || result[i - 1][j - a[i]];
				}
			}
		}
		return result[a.length - 1][r];
		// return helper(a, 0, r);
	}
//递归
	/*
	 * private boolean helper(int[] a, int index, int r) { if (index >= a.length)
	 * return false; if (a[index] == r) return true;
	 * 
	 * if (a[index] > r) return helper(a, ++index, r); index++; if (index <=
	 * a.length - 1) return helper(a, index, r) || helper(a, index, r - a[index]);
	 * else { return false; } }
	 */
}
