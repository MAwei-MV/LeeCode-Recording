package DailyPractice;

public class JZ34 {

	public int FirstNotRepeatingChar(String str) {
		if (str.length() == 0 || str == null)
			return -1;
		
		char[] Cstr = str.toCharArray();
		int[] count = new int[128];
		int x = -1;
		for (int i = 0; i < Cstr.length; i++) {
			count[Cstr[i]]++;
		}
		for (int j = 0; j < str.length(); j++) {
			if (count[Cstr[j]] == 1) {
				x = j;
				break;
			}
		}
		return x;
	}
}
