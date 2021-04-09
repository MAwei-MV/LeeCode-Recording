package LiKouPractice;

public class Pro357 {
	public static void main(String args[]) {
		Pro357 p = new Pro357();
		System.out.println(p.countNumbersWithUniqueDigits(1));
	}

	public int countNumbersWithUniqueDigits(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 10;
		int[] res = new int[n + 1];
		res[1] = 10;
		int h = 9;
		int k = 9;
		for (int i = 2; i <= n; i++) {
			h *= k;
			k--;
			res[i] += res[i - 1] + h;
		}
		return res[n];
	}
}
