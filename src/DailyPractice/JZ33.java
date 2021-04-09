package DailyPractice;

public class JZ33 {
	public static void main(String args[]) {
		JZ33 j = new JZ33();
		System.out.println(j.GetUglyNumber_Solution(0));
	}

	public int GetUglyNumber_Solution(int index) {
		int[] a = new int[index];
		if (index <= 0) {
			return 0;
		}
		a[0] = 1;
		int p2 = 0, p3 = 0, p5 = 0;
		for (int i = 1; i < index; i++) {
			a[i] = Math.min(a[p2] * 2, Math.min(a[p3] * 3, a[p5] * 5));
			if (a[i] == a[p2] * 2)
				p2++;
			if (a[i] == a[p3] * 3)
				p3++;
			if (a[i] == a[p5] * 5)
				p5++;
		}
		return a[index - 1];
	}
}
