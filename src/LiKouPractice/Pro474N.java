package LiKouPractice;

public class Pro474N {
//dp[i][j][k]的定义如下：
//若只使用前i个物品，当背包容量为j个0，k个1时，能够容纳的最多字符串数。
	public int findMaxForm(String[] strs, int m, int n) {
        int strsNum = strs.length;
        //dp[][] new出来即初始化为0
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= strsNum; i++) {
            int[] cnt = count(strs[i - 1]);
            for (int j = m; j >= cnt[0]; j--) {
                for(int k = n; k >= cnt[1]; k--) {
                        dp[j][k] = Math.max(dp[j][k], dp[j - cnt[0]][k - cnt[1]] + 1);
                 
                }
            }
        }

        return dp[m][n];
    }

    // cnt[0] = zeroNums, cnt[1] = oneNums
    public int[] count(String str) {
        int[] cnt = new int[2];
        for (char c : str.toCharArray()) {
            cnt[c - '0']++;
        }
        return cnt;
    }
}