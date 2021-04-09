package DailyPractice;

public class JZ67 {
	//�����ݹ�
	public int back_track(int n) {
		// n <= 4, �������֣�����������
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
		// number = 2 �� 3 ʱ���� 2 �κͷ� 1 �εĽ���ǲ�һ���ģ�������Ҫ����һ��
		if (number == 2) {
			return 1;
		} else if (number == 3) {
			return 2;
		}
		return back_track(number);
	}
}