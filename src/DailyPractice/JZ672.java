package DailyPractice;

public class JZ672 {
	//ÊıÑ§½âÎö
	public int cutRope(int target) {
		int[] sum = new int[target];
		for (int i = 0; i < sum.length; i++)
			sum[i] = 1;
		int target1=target;
		for (int i = 1; i <= target1; i++) {
			int flag = i;
			target=target1;
			while (target % flag != 0) {
				sum[i - 1] *= target / flag;
				target -= target / flag;
				flag--;
			}
			if (target != 0) {
				for (int j = 0; j < flag; j++)
					sum[i - 1] *= target / flag;
			}
		}
		int max = 1;
		for (int m = 0; m < sum.length; m++) {
			if (max < sum[m]) {
				max = sum[m];
			}
		}
		return max;
	}

	public static void main(String args[]) {
		JZ672 j = new JZ672();
		System.out.println(j.cutRope(21));
	}
}
