package DailyPractice;

import java.util.*;

public class JZ27 {
	/*
	 * toCharArray() 是一个将字符串转化为字符数组的方法。
	 * Arrays.sort()该方法，元素个数少于47时用插入排序，大于47小于286时用快速排序，大于286会转入归并排序（但是降序组太多时转回快排）
	 * public String(char value[]) { this.value = Arrays.copyOf(value,
	 * value.length); } 学会看源码 递归三部曲：1.递归函数的功能；2.递归终止条件；3.下一次递归
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
					// 用完还是要放回去的
					temp = strBu.charAt(0);
					strBu.setCharAt(0, strBu.charAt(i));
					strBu.setCharAt(i, temp);
				}
			}
		}
		return result;
	}
}
