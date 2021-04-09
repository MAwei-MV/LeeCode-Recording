package LiKouPractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Pro767 {
	public static void main(String args[]) {
		String S = "aab";
		Pro767 p = new Pro767();
		System.out.println(p.reorganizeString(S));
	}

	public String reorganizeString(String S) {
		char[] ch = S.toCharArray();
		StringBuffer sb = new StringBuffer();
		Map<Character, Integer> hm = new HashMap<>();
		for (char c : ch) {
			hm.put(c, hm.getOrDefault(c, 0) + 1);
		}
		List<Map.Entry<Character, Integer>> list = new ArrayList<Map.Entry<Character, Integer>>(hm.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
			public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		if (list.get(0).getValue() > (ch.length+1) / 2)
			return "";
		int i = 0;
		char res[] = new char[ch.length];
		while (i % 2 == 0 || i < ch.length) {
			res[i] = list.get(0).getKey();
			list.get(0).setValue(list.get(0).getValue() - 1);
			if (list.get(0).getValue() == 0)
				list.remove(0);
			if ((i % 2 == 0 && i == ch.length - 1) || (i % 2 == 0 && i == ch.length - 2))
				i = -1;
			i += 2;
		}
		for (char c : res) {
			sb.append(c);
		}
		return sb.toString();
	}
}
