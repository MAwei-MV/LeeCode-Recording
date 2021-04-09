package LiKouPractice;

public class Pro122 {
	public int maxProfit(int[] prices) {
		// res[i][0]表示第i天不持有股票的情况下，所能获得的最大利润；
		// res[i][1]表示第i天持有股票的情况下，所能获得的最大利润。
		if (prices.length <= 1)
			return 0;
		int res[][] = new int[prices.length][2];
		res[0][0]=0;
		res[0][1]=-prices[0];
		for (int i = 1; i < prices.length; i++) {
			res[i][0]=Math.max(res[i-1][1]+prices[i], res[i-1][0]);
			res[i][1]=Math.max(res[i-1][0]-prices[i], res[i-1][1]);
		}
		return res[prices.length-1][0];
	}
}
