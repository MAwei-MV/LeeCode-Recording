package LiKouPractice;

public class Pro474N {
//dp[i][j][k]�Ķ������£�
//��ֻʹ��ǰi����Ʒ������������Ϊj��0��k��1ʱ���ܹ����ɵ�����ַ�������
	public int findMaxForm(String[] strs, int m, int n) {
        int strsNum = strs.length;
        //dp[][] new��������ʼ��Ϊ0
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