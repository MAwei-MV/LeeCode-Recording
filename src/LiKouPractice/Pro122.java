package LiKouPractice;

public class Pro122 {
	public int maxProfit(int[] prices) {
		// res[i][0]��ʾ��i�첻���й�Ʊ������£����ܻ�õ��������
		// res[i][1]��ʾ��i����й�Ʊ������£����ܻ�õ��������
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
