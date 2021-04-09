package DailyPractice;

public class JZ673 {
	// º«“‰µ›πÈ
	public int back_track(int n, int[] mark) {
		if (n <= 4) {
			return n;
		}
		if (mark[n-1] != -1) {
			return mark[n-1];
		}
		int ret = 0;
		for (int i = 1; i < n; ++i) {
			ret = Math.max(ret, i * back_track(n - i, mark));
		}
		mark[n-1] = ret;
		return mark[n-1];
	}

	int cutRope(int number) {
		if (number == 2) {
			return 1;
		} else if (number == 3) {
			return 2;
		}
		int mark[] = new int[number];
		for (int i = 0; i < mark.length; i++)
			mark[i] = -1;
		return back_track(number, mark);
	}
	public static void main(String args[]) {
		JZ673 j=new JZ673();
		System.out.println(j.cutRope(15));
	}
}