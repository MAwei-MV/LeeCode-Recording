package DailyPractice;

/*
 *  &= �����������ƶ�Ӧλ��Ϊ1ʱ�����Ϊ1��������Ϊ��0��
 *  |= �� ���������ƶ�ӦλΪ0ʱ��λΪ0������Ϊ1��
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
