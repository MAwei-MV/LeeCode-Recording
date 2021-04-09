package LiKouPractice;

public class Pro746 {
	public static void main(String args[]) {
		Pro746 p = new Pro746();
		int a[] = { 10, 15, 20 };
		System.out.println(p.minCostClimbingStairs(a));
	}

	public int minCostClimbingStairs(int[] cost) {
		if (cost.length == 0)
			return 0;
		// 表示到达res[i]时的最低消耗
		int res[] = new int[cost.length];
		for (int i = 2; i < res.length; i++) {
			res[i] = Math.min(cost[i - 1] + res[i - 1], cost[i - 2] + res[i - 2]);
		}
		return Math.min(res[res.length - 1] + cost[res.length - 1], res[res.length - 2] + cost[res.length - 2]);
	}
}
