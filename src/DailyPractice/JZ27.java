package DailyPractice;

import java.util.*;

public class JZ27 {
	/*
	 * toCharArray() ��һ�����ַ���ת��Ϊ�ַ�����ķ�����
	 * Arrays.sort()�÷�����Ԫ�ظ�������47ʱ�ò������򣬴���47С��286ʱ�ÿ������򣬴���286��ת��鲢���򣨵��ǽ�����̫��ʱת�ؿ��ţ�
	 * public String(char value[]) { this.value = Arrays.copyOf(value,
	 * value.length); } ѧ�ῴԴ�� �ݹ���������1.�ݹ麯���Ĺ��ܣ�2.�ݹ���ֹ������3.��һ�εݹ�
	 */
	public ArrayList<String> Permutation(String str) {
		StringBuilder strBu = new StringBuilder(str);
		ArrayList<String> result = PermutationHelp(strBu);
		Collections.sort(result);
		return result;
	}

	private ArrayList<String> PermutationHelp(StringBuilder strBu) {
		ArrayList<String> result = new ArrayList<>();
		if (strBu.length() == 1)
			result.add(strBu.toString());
		else {
			for (int i = 0; i < strBu.length(); i++) {
				if (i == 0 || strBu.charAt(i) != strBu.charAt(0) ) {
					char temp = strBu.charAt(i);
					strBu.setCharAt(i, strBu.charAt(0));
					strBu.setCharAt(0, temp);
					ArrayList<String> newResult = PermutationHelp(new StringBuilder(strBu.substring(1)));
					for (int j = 0; j < newResult.size(); j++)
						result.add(strBu.substring(0, 1) + newResult.get(j));
					// ���껹��Ҫ�Ż�ȥ��
					temp = strBu.charAt(0);
					strBu.setCharAt(0, strBu.charAt(i));
					strBu.setCharAt(i, temp);
				}
			}
		}
		return result;
	}
}
