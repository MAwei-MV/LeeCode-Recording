package LiKouPractice;

public class Pro1370 {
	/*
	 * public String sortString(String s) { StringBuffer sb = new StringBuffer();
	 * char[] c = s.toCharArray(); Arrays.sort(c); Map<Character, Integer> m = new
	 * HashMap<>(); for (char x : c) { if (!m.containsKey(x)) { m.put(x, 1); } else
	 * { m.replace(x, m.get(x) + 1); } } while (!m.isEmpty()) {
	 * sb.append(m.keySet()); m. } }
	 */
	// 相当于26个桶
	public String sortString(String s) {
		int[] bucket = new int[26];
		char[] charArr = s.toCharArray();
		// 把s中的字符分别放到对应的桶里
		for (char c : charArr) {
			bucket[c - 'a']++;
		}
		// 存储计算的结果
		char[] res = new char[s.length()];
		int index = 0;
		while (index < s.length()) {
			// 先从左往右找，遍历26个桶,如果当前桶不为空，
			// 就从当前桶里拿出一个元素出来
			for (int i = 0; i < 26; i++) {
				if (bucket[i] != 0) {
					res[index++] = (char) (i + 'a');
					bucket[i]--;// 拿出之后桶中元素的个数要减1
				}
			}
			// 从右往左拿，同上
			for (int i = 25; i >= 0; i--) {
				if (bucket[i] != 0) {
					res[index++] = (char) (i + 'a');
					bucket[i]--;
				}
			}
		}
		// 把结果转化为字符串
		return new String(res);
	}
}
