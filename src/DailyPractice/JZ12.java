package DailyPractice;

// n&1 可判断奇偶性
// double x= 1.0d,后面的d表示double类型。类似的：1.0f表示float类型。
public class JZ12 {
	public double Power(double base, int exponent) {
		if (exponent < 0) {
			base = 1 / base;
			exponent = -exponent;
		}
		double x = 1.0d;
		for (int i = 1; i <= exponent; i++) {
			x= x * base;
		}
		return x;
	}
}
