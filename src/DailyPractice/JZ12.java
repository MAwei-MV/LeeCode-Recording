package DailyPractice;

// n&1 ���ж���ż��
// double x= 1.0d,�����d��ʾdouble���͡����Ƶģ�1.0f��ʾfloat���͡�
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
