package DailyPractice;

import java.util.Scanner;

public class JZ9 {
	public static void main(String args[]) {
		JZ9 j = new JZ9();
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		System.out.println(j.JumpFloorII(x));
	}

	public int JumpFloorII(int target) {
		int[] dp = new int[target + 1];
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i <= target; i++) {
			dp[i] = 2 * dp[i - 1];
		}
		return dp[target];
	}
}
