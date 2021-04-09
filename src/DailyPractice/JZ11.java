package DailyPractice;

/*
 *  &= ：两个二进制对应位都为1时，结果为1，否则结果为都0。
 *  |= ： 两个二进制对应位为0时该位为0，否则为1。
 */
public class JZ11 {
	public static void main(String args[]) {
		JZ11 j = new JZ11();
		System.out.println(j.NumberOf1(-5));
		int a = -6;
		a &= (-7);
		System.out.println(a);
	}

	public int NumberOf1(int n) {
		int count = 0;
		while (n != 0) {
			count++;
			n &= n - 1;
		}
		return count;
	}
}
