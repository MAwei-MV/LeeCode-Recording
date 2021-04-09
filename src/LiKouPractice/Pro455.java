package LiKouPractice;

import java.util.Arrays;

public class Pro455 {
	public static void main(String args[]) {
		int g[] = { 10, 9, 8, 7 };
		int[] s = { 5, 6, 7, 8 };
		Pro455 p = new Pro455();
		System.out.println(p.findContentChildren(g, s));
	}

	public int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);
		int i = 0, j = 0;
		int sum = 0;
		while (i < g.length && j < s.length) {
			if (s[j] >= g[i]) {
				sum++;
				i++;
				j++;
			} else {
				j++;
			}
		}
		return sum;
	}
}
