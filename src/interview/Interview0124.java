package interview;

public class Interview0124 {
	public static void main(String args[]) {
		String string = "123.2005";
		Interview0124 inter = new Interview0124();
		System.out.println(inter.test(string));
	}

	public double test(String s) {
		char[] c = s.toCharArray();
		int N = c.length;
		int flag = N;
		for (int i = 0; i < N; i++) {
			if (c[i] == '.') {
				flag = i;
				break;
			}
		}
		double pre = 0;
		double last = 0;
		// 整数部分
		for (int i = 0; i < flag; i++) {
			pre = pre * 10;
			pre += c[i] - '0';
		}
		// 小数部分
		for (int i = N - 1; i >= flag + 1; i--) {
			double temp = (double) (c[i] - '0') / 10;
			last /= 10;
			last += temp;
		}
		return pre + last;
	}
}
