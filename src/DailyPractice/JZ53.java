package DailyPractice;

public class JZ53 {
	/*
	 * ����д�� public boolean isNumeric(char[] str) { String pattern =
	 * "^[-+]?\\d*(?:\\.\\d*)?(?:[eE][+\\-]?\\d+)?$"; String s = new String(str);
	 * return Pattern.matches(pattern,s); }
	 * 1.+-�ź���ض�Ϊ���ֻ����Ϊ.(-213=-0.123)
	 * 2.+-��ֻ�����ڵ�һλ��eE�ĺ�һλ
	 * 3..����ض�Ϊ���ֻ�Ϊ���һλ(233.=233.0)
	 * 4.eE����ض�Ϊ���ֻ�+-��
	 */
	public boolean isNumeric(char[] str) {
		if (str.length == 0)
			return false;
		if (str.length == 1)
			if (str[0] < '0' || str[0] > '9')
				return false;

		// ��Ƿ��š�С���㡢e�Ƿ���ֹ�
		boolean sign = false, decimal = false, hasE = false;
		for (int i = 0; i < str.length; i++) {
			if (str[i] == 'e' || str[i] == 'E') {
				if (i == str.length - 1)
					return false; // e����һ��Ҫ������
				if (hasE)
					return false; // ����ͬʱ��������e
				hasE = true;
			} else if (str[i] == '+' || str[i] == '-') {
				// �ڶ��γ���+-���ţ�����������e֮��
				if (sign && str[i - 1] != 'e' && str[i - 1] != 'E')
					return false;
				// ��һ�γ���+-���ţ��Ҳ������ַ�����ͷ����Ҳ���������e֮��
				if (!sign && i > 0 && str[i - 1] != 'e' && str[i - 1] != 'E')
					return false;
				sign = true;
			} else if (str[i] == '.') {
				// e���治�ܽ�С���㣬С���㲻�ܳ�������
				if (hasE || decimal)
					return false;
				decimal = true;
			} else if (str[i] < '0' || str[i] > '9') // ���Ϸ��ַ�
				return false;
		}
		return true;
	}
}
