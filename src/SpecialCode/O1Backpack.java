package SpecialCode;

public class O1Backpack {
//01�������⣺����һ��������{2,3}��ʾ��ֵΪ2������Ϊ3��
//ͬʱ����һ��������ʾ����������������װ������ֵ����Ʒ
	public static void main(String args[]) {
		int[][] a = { { 3, 2 }, { 4, 3 }, { 5, 4 }, { 6, 5 } };
		int w = 8;
		O1Backpack o = new O1Backpack();
		System.out.println(o.getMaxValue(a, w));
	}
	/*
	 * public int getMaxValue(int[][] t, int w) { // 1.����01�����ⷨ�� //
	 * dp[i][j]��������Ϊj��ǰi����Ʒ����װ������ֵ�� /* int dp[][] = new int[t.length + 1][w + 1];
	 * for (int i = 1; i < dp.length; i++) { for (int j = 1; j < dp[0].length; j++)
	 * { if (j < t[i - 1][1]) { // װ���� dp[i][j] = dp[i - 1][j]; } // ��װ�� else {
	 * dp[i][j] = Math.max(dp[i - 1][j], t[i - 1][0] + dp[i - 1][j - t[i - 1][1]]);
	 * } } } return dp[dp.length - 1][w]; }
	 */

	public int getMaxValue(int[][] t, int w) { // 2.�Ż��ռ���01����
		int dp[] = new int[w + 1];
		for (int i = 0; i < t.length; i++) {
			for (int j = w; j >= t[i][1]; j--) {
				dp[j] = Math.max(dp[j], dp[j - t[i][1]] + t[i][0]);
			}
		}
		return dp[w];
	}

}
