package LiKouPractice;

import java.util.ArrayList;
import java.util.List;

public class Pro842 {
	public static void main(String args[]) {
		String s = "12315";
		Pro842 p = new Pro842();
		System.out.println(p.splitIntoFibonacci(s));
	}

	public List<Integer> splitIntoFibonacci(String S) {
		List<Integer> res = new ArrayList<>();
		helper(S.toCharArray(), res, 0);
		return res;
	}

	/*
	 * List<Integer> res = new ArrayList<>(); backtrack(S.toCharArray(), res, 0);
	 * return res;
	 */
	private Boolean helper(char[] s, List<Integer> res, int index) {
		if (index >= s.length && res.size() >= 3)
			return true;
		for (int i = index; i < s.length; i++) {
			if (s[index] == '0' && i > index)
				break;
			long num = cal(s, index, i + 1);
			if (num > Integer.MAX_VALUE)
				break;
			int size=res.size();
			 if (size >= 2 && res.get(size - 1) + res.get(size - 2) < num) {
				break;
			}
			 if (size <= 1 || res.get(size - 1) + res.get(size - 2) == num) {
				res.add((int) num);
				if (helper(s, res, i + 1)) {
					return true;
				}
				  res.remove(res.size() - 1);
			} 
		}
		return false;
	}

	private long cal(char[] s, int start, int end) {
		long res = 0;
		for (int i = start; i < end; i++) {
			res = res * 10 + s[i] - '0';
		}
		return res;
	}
}

/*
 * public boolean backtrack(char[] digit, List<Integer> res, int index) { //
 * �߽������жϣ������ȡ���ˣ�����res���ȴ��ڵ���3����ʾ�ҵ���һ����ϡ� if (index == digit.length && res.size()
 * >= 3) { return true; } for (int i = index; i < digit.length; i++) { //
 * ��λ���ϵ����ֲ�����0��ͷ if (digit[index] == '0' && i > index) { break; } // ��ȡ�ַ���ת��Ϊ����
 * long num = subDigit(digit, index, i + 1); // �����ȡ�����ִ���int�����ֵ������ֹ��ȡ if (num >
 * Integer.MAX_VALUE) { break; } int size = res.size(); //
 * �����ȡ�����ִ���res��ǰ�������ֵĺͣ�˵����ν�ȡ��̫��ֱ����ֹ����Ϊ����Խ��ȡԽ�� if (size >= 2 && num >
 * res.get(size - 1) + res.get(size - 2)) { break; } if (size <= 1 || num ==
 * res.get(size - 1) + res.get(size - 2)) { // ������num��ӵ�����res�� res.add((int)
 * num); // ����ҵ��˾�ֱ�ӷ��� if (backtrack(digit, res, i + 1)) return true; //
 * ���û�ҵ����ͻ��߻�����һ����Ȼ�����һ����ӵ�����res�е����ָ��Ƴ��� res.remove(res.size() - 1); } } return
 * false; }
 * 
 * // �൱�ڽ�ȡ�ַ���S�е��Ӵ�Ȼ��ת��Ϊʮ�������� private long subDigit(char[] digit, int start, int
 * end) { long res = 0; for (int i = start; i < end; i++) { res = res * 10 +
 * digit[i] - '0'; } return res; } }
 */