package DailyPractice;

public class JZ32 {
	static StringBuffer sb = new StringBuffer();

	public String PrintMinNumber(int[] number) {
		sb.setLength(0);
		if (number.length == 0)
			return null;
		String[] StrNumber = new String[number.length];
		for (int i = 0; i < number.length; i++) {
			StrNumber[i] = Integer.toString(number[i]);
		}
		GetMinNumber(StrNumber);
		return sb.toString();
	}

	private void GetMinNumber(String[] strNumber) {
		if (strNumber.length == 0)
			return;
		if (strNumber.length == 1) {
			sb.append(strNumber[0]);
		} else {
			for (int i = 1; i < strNumber.length; i++) {
				if (Integer.parseInt((new StringBuffer(strNumber[0]).append(strNumber[i]).toString())) > Integer
						.parseInt(new StringBuffer(strNumber[i]).append(strNumber[0]).toString())) {
					String temp = strNumber[i];
					strNumber[i] = strNumber[0];
					strNumber[0] = temp;
				}
			}
			sb.append(strNumber[0]);
			GetMinNumber(java.util.Arrays.copyOfRange(strNumber, 1, strNumber.length));
		}
	}
}