package DailyPractice;

public class JZ43 {
	/*
	 * public String substring(int beginIndex) //��ͷ����β
	 * public String substring(int beginIndex, int endIndex)
	 */
	public String LeftRotateString(String str, int n) {
		if (str == null || n > str.length()) {
			return str;
		}
		return str.substring(n) + str.substring(0, n);
	}
}
