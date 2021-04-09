package LiKouPractice;

import java.util.HashMap;
import java.util.Map;

public class Pro467 {
	/*
	 * static char[] s = { 'z', 'y', 'x', 'w', 'v', 'u', 't', 's', 'r', 'q', 'p',
	 * 'o', 'n', 'm', 'l', 'k', 'j', 'i', 'h', 'g', 'f', 'e', 'd', 'c', 'b', 'a' };
	 */
	public static void main(String args[]) {
		String p = "zab";
		Pro467 p1 = new Pro467();
		System.out.println(p1.findSubstringInWraproundString(p));
	}

	// 未利用前缀和解题，花了2个多小时
	/*
	 * public int findSubstringInWraproundString(String p) { int flag[] = new
	 * int[26]; if (p.length() <= 1) return p.length(); int res[] = new
	 * int[p.length() + 1]; res[0] = 0; res[1] = 1; flag[p.charAt(0) - 97] = 1; for
	 * (int i = 2; i < res.length; i++) { int x = 1; int r = 0; for (int j = i - 1;
	 * j >= 1; j--) { if (getProChar(p.charAt(j)) == p.charAt(j - 1)) { x++; } else
	 * { break; } } if (x > flag[p.charAt(i - 1) - 97]) { r = x - flag[p.charAt(i -
	 * 1) - 97]; flag[p.charAt(i - 1) - 97] = x; } res[i] = res[i - 1] + r; } return
	 * res[p.length()]; }
	 * 
	 * public char getProChar(char c) { if (c == 'a') return 'z'; else { return
	 * (char) (c - 1); } }
	 */
	// 滑动窗口解题，看好：
	public int findSubstringInWraproundString(String p) {
		if (p.length() == 0 || p.length() == 1)
			return p.length();
		int pre = 1;

		HashMap<Character, Integer> hm = new HashMap<>();
		hm.put(p.charAt(0), 1);
		for (int i = 1; i < p.length(); i++) {
			if (p.charAt(i) - p.charAt(i - 1) == 1 || p.charAt(i) - p.charAt(i - 1) == -25) {
				pre += 1;
			} else
				pre = 1;
			if (hm.get(p.charAt(i)) == null) {
				hm.put(p.charAt(i), pre);
			} else {
				int x = hm.get(p.charAt(i));
				hm.replace(p.charAt(i), Math.max(x, pre));
			}
		}
		// Iterating entries using a For Each loop
		// for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
		// System.out.println("Key = " + entry.getKey() + ", Value = " +
		// entry.getValue());
		// }
		/*
		 * 迭代键 for (Integer key : map.keySet()) { System.out.println("Key = " + key); }
		 * 
		 *  迭代值 for (Integer value : map.values()) { System.out.println("Value = " +
		 * value); }
		 */
		int sum = 0;
		for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
			sum += entry.getValue();
		}
		return sum;
	}
}
