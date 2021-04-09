package LiKouPractice;

public class Pro50 {
	public double myPow(double x, int n) {
		/*
		 * �����ⷨ��ʱ�临�ӶȲ�����Ҫ�� O(n) long N = n; if (n == 0) return 1; else { if (N < 0) { x
		 * = 1 / x; N = -N; } int ans = 1; for (long i = 0; i < N; i++) { ans *= x; }
		 * return ans; } }
		 */
		// Ӧ���뵽�÷��η�ʱ�临�ӶȽ�ΪO(longn)
		if (x == 1 || n == 0)
			return 1;
		long N;
		if (n < 0) {
			N = -n;
			x = 1 / x;
		} else {
			N = n;
		}
		return helper(x, N);
	}

	public double helper(double x, long n) {
		if (n == 1)
			return x;
		if (n == 0)
			return 1;
		if (n % 2 == 0)
			return helper(x * x, n / 2) ;
		else {
			return helper(x * x, n / 2) * x;
		}
	}
}