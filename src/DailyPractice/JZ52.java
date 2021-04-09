package DailyPractice;

public class JZ52 {
	public boolean match(char[] str, char[] pattern) {
		if (str == null || pattern == null)
			return false;
		return GetValue(str, 0, pattern, 0);
	}

	private boolean GetValue(char[] str, int i, char[] pattern, int j) {
		if (i == str.length && j == pattern.length)
			return true;
		if (i < str.length && j == pattern.length)
			return false;
		if (j + 1 <= pattern.length - 1 && pattern[j + 1] == '*') {
			if ((i < str.length && str[i] == pattern[j]) || (i < str.length && pattern[j] == '.')) {
				return GetValue(str, i + 1, pattern, j) || GetValue(str, i + 1, pattern, j + 2)
						|| GetValue(str, i, pattern, j + 2);
			} else {
				return GetValue(str, i, pattern, j + 2);
			}
		} else if (i < str.length && (pattern[j] == str[i] || pattern[j] == '.')) {
			return GetValue(str, i + 1, pattern, j + 1);
		}
		return false;
	}
}