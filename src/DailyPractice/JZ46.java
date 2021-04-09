package DailyPractice;

import java.util.ArrayList;
import java.util.List;

//不会
public class JZ46 {
	/*
	 * public int LastRemaining_Solution(int n, int m) { if (m < 1 || n < 1) return
	 * -1; List<Integer> list = new ArrayList<>(); for (int i = 0; i < n; i++) {
	 * list.add(i); } int cur = -1; while (list.size() > 1) { for (int i = 0; i < m;
	 * i++) { cur++; if (cur == list.size()) cur = 0; } list.remove(cur); cur--; }
	 * return list.get(0); }
	 */
	
	public int LastRemaining_Solution(int n, int m) {
	    // 不满足的条件
	    if (n <= 0 || m <= 0) return -1;
	    return n == 1 ? 0 : (LastRemaining_Solution(n - 1, m) + m) % n;
	  }
}