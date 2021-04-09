package DailyPractice;

public class JZ44 {
	public String ReverseSentence(String str) {
		String[] s = str.split("\\s+");// °´¿Õ¸ñÇĞ¸î
		String ss = new String();
		if (s == null|| s.length==0)
			return str;
		for (int i = s.length - 1; i >= 0; i--) {
			if (i != 0)
				ss += s[i] + " ";
			else {
				ss += s[i];
			}
		}

		return ss;
	}
}
