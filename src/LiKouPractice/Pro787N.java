package LiKouPractice;

import java.util.Arrays;

public class Pro787N {
	public static void main(String args[]) {
		Pro787N p = new Pro787N();
		/*
		 * int[][] flights = { { 1, 2, 10 }, { 2, 0, 7 }, { 1, 3, 8 }, { 4, 0, 10 }, {
		 * 3, 4, 2 }, { 4, 2, 10 }, { 0, 3, 3 }, { 3, 1, 6 }, { 2, 4, 5 } };
		 */
		int[][] flights = { { 0, 1, 100 }, { 1, 2, 100 }, { 0, 2, 500 } };
		System.out.println(p.findCheapestPrice(3, flights, 0, 2, 10));
	}

	/*
	 * int x = 0;
	 * 
	 * public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K)
	 * { int minValue = 99999; int flag[] = new int[n]; for (int i = 0; i <
	 * flights.length; i++) { if (flights[i][0] == src) { flag[flights[i][0]] = 1;
	 * int value = helper(i, flag, flights, src, dst, K); if (value != 0) minValue =
	 * Math.min(minValue, value); for (int k = 0; k < flag.length; k++) { flag[k] =
	 * 0; } x = 0; } } if (minValue == 99999) return -1; return minValue; }
	 * 
	 * public int helper(int index, int flag[], int[][] flights, int src, int dst,
	 * int K) { if (K < 0 || flag[flights[index][1]] == 1) return 0; int value = 0;
	 * if (flights[index][1] == dst) { value = flights[index][2]; x = 1; } else {
	 * flag[flights[index][1]] = 1; for (int i = 0; i < flights.length; i++) { if
	 * (flights[i][0] == flights[index][1]) { value = flights[index][2] + helper(i,
	 * flag, flights, flights[i][0], dst, K - 1); } } } if (x == 1) return value;
	 * else return 0; }
	 */
	/*
	 * public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K)
	 * { // 表示各节点经过K次中转到达目的地的最短时间； int[][] result = new int[n][K + 1]; //
	 * 直接全部赋值的简便方法 for (int i = 0; i < n; ++i) Arrays.fill(result[i],
	 * Integer.MAX_VALUE);
	 * 
	 * for (int[] flight : flights) { if (flight[0] == src) { result[flight[1]][0] =
	 * flight[2]; } } // 循环初始化数组中dst == src的行 for (int i = 0; i <= K; i++) {
	 * result[src][i] = 0; }
	 * 
	 * for (int i = 1; i < K + 1; i++) { for (int[] flight : flights) { if
	 * (result[flight[0]][i - 1] != Integer.MAX_VALUE) { result[flight[1]][i] =
	 * Math.min(result[flight[1]][i], result[flight[0]][i - 1] + flight[2]); } } }
	 * return result[dst][K] == Integer.MAX_VALUE ? -1 : result[dst][K]; }
	 */

	/*
	 * private int helper(int index, int flag[], int[][] flights, int src, int dst,
	 * int K) { if (index >= flights.length || K < 0) return Integer.MIN_VALUE; if
	 * (flag[index] == 1) return 0; if (flights[index][1] == dst) return
	 * flights[index][2]; if (flights[index][0] == src) { K--; flag[index] = 1;
	 * for(int i=0;i<flights.length;i++) { int x = flights[index][2] + helper(i,
	 * flag, flights, flights[index][1], dst, K); int y = helper(++index, flag,
	 * flights, src, dst, K); if (x > 0 && y > 0) return Math.min(x, y); else if (x
	 * <= 0) return y; else if (y <= 0) return x; return -1; } } return
	 * helper(++index, flag, flights, src, dst, K); }
	 */
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
		// 表示各节点经过K次中转到达目的地的最短时间；
		int[][] result = new int[n][K + 1];
		for (int i = 0; i < n; ++i)
			Arrays.fill(result[i], Integer.MAX_VALUE);
		for (int i = 0; i < K + 1; i++) {
			result[dst][i] = 0;
		}
		for (int[] flight : flights) {
			if (flight[1] == dst)
				result[flight[0]][0] = flight[2];
		}
		for (int k = 1; k < K + 1; k++) {
			for (int flight[] : flights) {
				if (result[flight[1]][k - 1] != Integer.MAX_VALUE) {
					result[flight[0]][k] = Math.min(flight[2] + result[flight[1]][k - 1], result[flight[0]][k]);
				}
			}
		}
		return result[src][K] == Integer.MAX_VALUE ? -1 : result[src][K];
	}
}
