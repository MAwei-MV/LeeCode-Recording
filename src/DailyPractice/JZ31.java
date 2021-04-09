package DailyPractice;

public class JZ31 {
	public static void main(String args[]) {
		JZ31 j = new JZ31();

		System.out.println(j.NumberOf1Between1AndN_Solution(10));
	}

	public int NumberOf1Between1AndN_Solution(int n) {
		int cur = n % 10;
		int low = 0;
		int high = n / 10;
		int sum = 0;
		int digit = 1;
		while (high != 0 || cur != 0) {
			if (cur == 0) {
				sum += high * digit;
			} else if (cur == 1) {
				sum += high * digit + low + 1;
			} else {
				sum += (high + 1) * digit;
			}
			low += cur * digit;
			cur = high % 10;
			high = high / 10;
			digit = digit * 10;
		}
		return sum;
	}
}