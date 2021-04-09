package LiKouPractice;

import java.util.Arrays;

public class Pro121 {
	public int maxProfit(int[] prices) {
		if(prices.length<=1) return 0;
		int dp[] = new int[prices.length];
		int minPrice = 10000;
		for (int i = 0; i < prices.length; i++) {
			dp[i] = prices[i] - minPrice;
			minPrice = Math.min(minPrice, prices[i]);
		}
		Arrays.sort(dp);
		int res=dp[dp.length-1];
		return res>=0?res:0;
	}
}
