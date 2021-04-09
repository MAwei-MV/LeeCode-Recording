package LiKouPractice;

public class Pro1370 {
	/*
	 * public String sortString(String s) { StringBuffer sb = new StringBuffer();
	 * char[] c = s.toCharArray(); Arrays.sort(c); Map<Character, Integer> m = new
	 * HashMap<>(); for (char x : c) { if (!m.containsKey(x)) { m.put(x, 1); } else
	 * { m.replace(x, m.get(x) + 1); } } while (!m.isEmpty()) {
	 * sb.append(m.keySet()); m. } }
	 */
	// �൱��26��Ͱ
	public String sortString(String s) {
		int[] bucket = new int[26];
		char[] charArr = s.toCharArray();
		// ��s�е��ַ��ֱ�ŵ���Ӧ��Ͱ��
		for (char c : charArr) {
			bucket[c - 'a']++;
		}
		// �洢����Ľ��
		char[] res = new char[s.length()];
		int index = 0;
		while (index < s.length()) {
			// �ȴ��������ң�����26��Ͱ,�����ǰͰ��Ϊ�գ�
			// �ʹӵ�ǰͰ���ó�һ��Ԫ�س���
			for (int i = 0; i < 26; i++) {
				if (bucket[i] != 0) {
					res[index++] = (char) (i + 'a');
					bucket[i]--;// �ó�֮��Ͱ��Ԫ�صĸ���Ҫ��1
				}
			}
			// ���������ã�ͬ��
			for (int i = 25; i >= 0; i--) {
				if (bucket[i] != 0) {
					res[index++] = (char) (i + 'a');
					bucket[i]--;
				}
			}
		}
		// �ѽ��ת��Ϊ�ַ���
		return new String(res);
	}
}
