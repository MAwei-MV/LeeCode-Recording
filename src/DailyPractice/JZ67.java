package DailyPractice;

public class JZ67 {
	//暴力递归
	public int back_track(int n) {
		// n <= 4, 表明不分，长度是最大的
		if (n <= 4) {
			return n;
		}
		int ret = 0;
		for (int i = 1; i < n; ++i) {
			ret = Math.max(ret, i * back_track(n - i));
		}
		return ret;
	}
	int cutRope(int number) {
		// number = 2 和 3 时，分 2 段和分 1 段的结果是不一样的，所以需要特判一下
		if (number == 2) {
			return 1;
		} else if (number == 3) {
			return 2;
		}
		return back_track(number);
	}
}