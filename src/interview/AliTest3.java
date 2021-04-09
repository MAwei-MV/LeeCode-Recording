package interview;

import java.util.Scanner;

public class AliTest3 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < x; i++) {
			int a = sc.nextInt();
			sc.nextLine();
			String s = sc.nextLine();
			String[] str = s.split("\\s+");
			int[] arr = new int[str.length];
			for (int j = 0; j < arr.length; j++) {
				arr[j] = Integer.parseInt(str[j]);
			}
			System.out.println(helper(arr));
		}
	}

	public static int helper(int arr[]) {
		int len = arr.length;
		if (len == 0)
			return 0;
		if (len == 1) {
			return arr[0];
		}
		if (len == 2) {
			return arr[0] + arr[1] / 2 + (arr[1] % 2 == 0 ? 0 : 1);
		}
		// dp[index]到达位置index-1时能获得的最大分值
		int dp[] = new int[len];
		dp[0] = arr[0];
		dp[1] = arr[0] + arr[1] / 2 + (arr[1] % 2 == 0 ? 0 : 1);
		for (int i = 2; i < len; i++) {
			dp[i] = Math.max(dp[i - 1] + (arr[i] / 2 + (arr[i] % 2 == 0 ? 0 : 1)), dp[i - 2] + arr[i]);
		}
		return dp[len - 1];
	}
}
