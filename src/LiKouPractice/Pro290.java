package LiKouPractice;

import java.util.HashMap;

public class Pro290 {
	public boolean wordPattern(String pattern, String s) {
		HashMap<Character, String> hm = new HashMap<>();
		String[] r = s.split(" ");
		if (pattern.length() != r.length)
			return false;
		for (int i = 0; i < pattern.length(); i++) {
			if (hm.containsKey(pattern.charAt(i))) {
				if (!hm.get(pattern.charAt(i)).equals(r[i]))
					return false;
			} else if (hm.containsValue(r[i]))
				return false;
			else {
				hm.put(pattern.charAt(i), r[i]);
			}
		}
		return true;
	}
}
