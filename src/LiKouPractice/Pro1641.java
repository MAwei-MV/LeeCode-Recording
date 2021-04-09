package LiKouPractice;

public class Pro1641 {
	public int countVowelStrings(int n) {
		// ����dp[n][5]���飬����dp[i][0-4]��ʾ
		// ����Ϊi����a-u��β���ַ����ĸ��������ƹ�ϵ������
		int[][] dp = new int[n + 1][5];
		// ��ʼ��n=1�����
		for (int i = 0; i < 5; i++) {
			dp[1][i] = 1;
		}

		for (int i = 2; i <= n; i++) {
			dp[i][0] = dp[i - 1][0];
			for (int j = 1; j < 5; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
			// ����i����u��β���ַ�������������һ������i-1���ַ�����β�Ӹ�u�õ�
			/*
			 * dp[i][4] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3] + dp[i -
			 * 1][4]; dp[i][3] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3];
			 * dp[i][2] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]; dp[i][1] = dp[i -
			 * 1][0] + dp[i - 1][1]; dp[i][0] = dp[i - 1][0];
			 */
		}

		// ���մ�����;�����
		return dp[n][0] + dp[n][1] + dp[n][2] + dp[n][3] + dp[n][4];
	}
}