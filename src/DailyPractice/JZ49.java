package DailyPractice;

public class JZ49 {
	public int StrToInt(String str) {
		if (str == null || str.length() == 0)
			return 0;
		int tag = 0;
		int start = 0;
		char c = str.charAt(0);
		if (c == '-') {
			tag = 1;
			start = 1;
		} else if (c == '+') {
			start = 1;
		}
		long res = 0;
		for (int i = start; i < str.length(); i++) {
			if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				res = res * 10 + str.charAt(i) - '0';
				if (tag == 0 && res > Integer.MAX_VALUE)
					throw new IllegalArgumentException("超上界");
				if (tag == 1 && res < Integer.MIN_VALUE)
					throw new IllegalArgumentException("超下界");
			} else {
				return 0;
			}

		}
		if (tag == 1) {
			return (int) -res;
		} else {
			return (int) res;
		}
	}

	/*
	 * public int StrToInt(String str) { if (str == null || str.length() == 0)
	 * return 0; int tag = 1; int start = 0; char ch = str.charAt(0); if (ch == '+')
	 * { start = 1; } else if (ch == '-') { tag = 0; start = 1; } long res = 0; for
	 * (int i = start; i < str.length(); i++) { char c = str.charAt(i); if (c >= '0'
	 * && c <= '9') { res = res * 10 + c - '0'; if (tag == 1 && res >
	 * Integer.MAX_VALUE) { throw new IllegalArgumentException("超上界"); } if (tag ==
	 * 0 && res < Integer.MIN_VALUE) { throw new IllegalArgumentException("超下界"); }
	 * } else { return 0; } }
	 * 
	 * if (tag == 0) { return (int) -res; } else { return (int) res; }
	 * 
	 * }
	 */
}