package LiKouPractice;

public class Pro201 {
	// 通过位移，即求m,n的公共前缀
	/*
	 * public int rangeBitwiseAnd(int m, int n) { int flag = 0; while (m < n) { m
	 * >>= 1; n >>= 1; flag++; } return m << flag; }
	 */
	// Brian Kernighan 算法
	public int rangeBitwiseAnd(int m, int n) {
		while (m < n) {
			// 抹去最右边的 1
			n = n & (n - 1);
		}
		return n;
	}
}
