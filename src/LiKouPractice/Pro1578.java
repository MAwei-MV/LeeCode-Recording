package LiKouPractice;

public class Pro1578 {
	// Ì°ÐÄ£¬¸´ÔÓ¶ÈÌ«´ó
	/*
	 * public int minCost(String s, int[] cost) { int i = 0; int sum = 0; if (s ==
	 * null || cost.length == 0) return 0; while (i <= s.length()) { int flag = -1;
	 * while (s.length() > (i + 1) && s.charAt(i) == s.charAt(i + 1)) { if (flag ==
	 * -1 && cost[i] <= cost[i + 1]) { sum += cost[i]; flag = cost[i + 1]; } else if
	 * (flag == -1 && cost[i] > cost[i + 1]) { sum += cost[i + 1]; flag = cost[i]; }
	 * else if (flag <= cost[i + 1]) { sum += flag; flag = cost[i + 1]; } else if
	 * (flag > cost[i + 1]) { sum += cost[i + 1]; } i++; } i++; } return sum; }
	 */
	public int minCost(String s, int[] cost) {
		int i = 0, len = s.length();
		int ret = 0;
		while (i < len) {
			char ch = s.charAt(i);
			int maxValue = 0;
			int sum = 0;

			while (i < len && s.charAt(i) == ch) {
				maxValue = Math.max(maxValue, cost[i]);
				sum += cost[i];
				i++;
			}
			ret += (sum - maxValue);
		}
		return ret;
	}

	public static void main(String args[]) {
		Pro1578 p = new Pro1578();
		String s = "aabaa";
		int[] l = { 1, 2, 3, 4, 1 };
		System.out.println(p.minCost(s, l));
	}
}
