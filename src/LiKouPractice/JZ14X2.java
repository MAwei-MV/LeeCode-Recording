package LiKouPractice;

public class JZ14X2 {
	public static void main(String args[]) {
		JZ14X2 j = new JZ14X2();
		System.out.println(j.cuttingRope(120));
	}

	// ����Ϊn����m�Σ��˻����Ϊ
	/*
	 * ���ⲻ��DP����Ϊ���ܴ�ʱ�����Ѿ������Ƚϴ�С�ķ�Χ��ȡ�������ܱȽϴ�С public int cuttingRope(int n) { int m =
	 * n; // �ܳ���Ϊn�����ӷֳ�m�ε���󳤶� int res[][] = new int[n + 1][m + 1]; for (int i = 1;
	 * i < n + 1; i++) { // ���ܶ೤��m=1ʱ���˻�Ϊnֵ res[i][1] = i; // n���ȷ�n�Σ��˻�Ϊ1 res[i][i]
	 * = 1; } // ��ʼ��� for (int i = 2; i < n + 1; i++) { for (int j = 2; j < i; j++)
	 * { for (int k = 2; i - k > 0; k++) res[i][j] = Math.max(res[i][j], res[i -
	 * k][j - 1] * k); } } int max = 0; for (int i = 1; i < m + 1; i++) { max =
	 * Math.max(res[n][i], max); } return max; }
	 */
	//������ѧ��ʽ�ã�������nֵ�и�Ϊ���3ʱ�����ó˻����
	public int cuttingRope(int n) {
		if (n < 4) {
			return n - 1;
		} else if (n == 4) {
			return n;
		}
		long res = 1;
		while (n > 4) {
			res *= 3;
			res %= 1000000007;
			n -= 3;
		}
		return (int) (res * n % 1000000007);
	}
}