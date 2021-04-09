package DailyPractice;

//位运算，比较模糊
public class JZ48 {
	public int Add(int num1, int num2) {
		int result = 0;
		int cur = 0;
		do {
			result = num1 ^ num2;
			cur = (num1 & num2) << 1;
			num1 = result;
			num2 = cur;
		} while (cur != 0);
		return result;
	}
}
