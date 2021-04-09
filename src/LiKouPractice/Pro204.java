package LiKouPractice;

import java.util.Arrays;

public class Pro204 {
	public static void main(String args[]) {
		Pro204 p = new Pro204();
		System.out.println(p.countPrimes(499979));
	}

	// 超时
	/*
	 * public int countPrimes(int n) { if (n <= 2) return 0; int res[] = new int[n];
	 * res[0] = 2; int flag = 1; for (int i = 3; i < n; i += 2) { int j = 1; boolean
	 * b = true; while (res[j] != 0) { if (i % res[j] == 0) { b = false; break; }
	 * j++; } if (b) { res[flag] = i; flag++; } } int index = 0; while (res[index]
	 * != 0) index++; return index; }
	 */
	public int countPrimes(int n) {
		boolean[] isPrim = new boolean[n];
		Arrays.fill(isPrim, true);
		// 从 2 开始枚举到 sqrt(n)。
		for (int i = 2; i * i < n; i++) {
			// 如果当前是素数
			if (isPrim[i]) {
				// 就把从 i*i 开始，i 的所有倍数都设置为 false。
				for (int j = i * i; j < n; j += i) {
					isPrim[j] = false;
				}
			}
		}

		// 计数
		int cnt = 0;
		for (int i = 2; i < n; i++) {
			if (isPrim[i]) {
				cnt++;
			}
		}
		return cnt;
	}
}