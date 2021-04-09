package DailyPractice;

public class JZ674 {
//¶¯Ì¬¹æ»®
	public int cutRope(int target) {
		if (target == 2)
			return 1;
		if (target == 3)
			return 2;
		int[] sum = new int[target];
		for (int i = 0; i < sum.length; i++) {
			sum[i] = -1;
		}
		for (int i = 0; i < 4; ++i) {
			sum[i] = i + 1;
		}
		for (int i = 4; i <= target - 1; ++i) {
			for (int j = 1; j <= i; ++j) {
				sum[i] = Math.max(sum[i], j * sum[i - j]);
			}
		}
		return sum[target - 1];
	}
}
