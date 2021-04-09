package LiKouPractice;

public class Pro14 {
	public String longestCommonPrefix(String[] strs) {
		String res = strs[0];
		for (int i = 0; i < strs.length; i++) {
			int j = 0;
			char c1[] = strs[i].toCharArray();
			char c2[] = res.toCharArray();
			for (; j < Math.min(res.length(), strs[i].length()); i++) {
				if (c1[j] != c2[j]) {
					break;
				}
			}
			res = res.substring(0, j);
			if (res == " ")
				return res;
		}
		return res;
	}
}
