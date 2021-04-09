package LiKouPractice;

import java.util.HashMap;

public class Pro387 {
	public static void main(String args[]) {
		String s = "dafafascz";
		Pro387 p = new Pro387();
		System.out.println(p.firstUniqChar(s));
	}

	public int firstUniqChar(String s) {
		char[] c = s.toCharArray();
		HashMap<Character, Integer> hm = new HashMap<>();
		for (int i = 0; i < c.length; i++) {
			hm.put(c[i], hm.getOrDefault(c[i], 0) + 1);
		}
		for(int i=0;i<c.length;i++) {
			if(hm.get(c[i])==1) {
				return i;
			}
		}
		return -1;
	}
}
