package interview;

import java.util.Scanner;

public class AliTest1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int index = 0;
		while (index <= 9) {
			int n = sc.nextInt();
			sc.nextLine();
			String s = sc.nextLine();
			String[] str = s.split("\\s+");
			int[] arr = new int[str.length];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(str[i]);
			}
			System.out.println(helper(arr, n));
			index++;
		}
	}

	// arr数组中能否找到某些数的和刚好等于n，arr[]是一个正数数组
	public static boolean helper(int arr[], int n) {
		//dp[x]=1表示能找到某些数相加得到x，dp[x]=0表示不能
		int dp[] = new int[n + 1];
		dp[0] = 1;
		for (int i = 0; i < arr.length; i++) {
			for (int j = n; j >= 0; j--) {
				if (j >= arr[i] && dp[j - arr[i]] == 1) {
					dp[j] = 1;
				}
			}
		}
		return dp[n] == 1;
	}
}
