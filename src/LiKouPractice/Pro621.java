package LiKouPractice;

public class Pro621 {
	public int leastInterval(char[] tasks, int n) {
		int[] charCount = new int[26];
		int max = 0, maxCount = 0;
		for (char task : tasks) {
			++charCount[task - 'A'];
		}
		for (int num : charCount) {
			if (num > max) {
				max = num;
				maxCount = 1;
			} else if (num == max) {
				++maxCount;
			}
		}
		// �жϼ���ڵĿռ��ܲ��ܷ��³���<��һ��><���>������ĸ�������ĸ
		int space = n * (max - 1) - (maxCount - 1) - (tasks.length - maxCount * max);
		// ����Ų��£�˵��ԭ���鳤�Ⱦ��ǽ��
		if (space < 0) {
			return tasks.length;
		} else {
			// ����ŵ��£����ǵ�һ����������ĸ�ĳ��ȣ��ټ��Ϻ���������ȵ���ĸ����
			return n * (max - 1) + max + maxCount - 1;
		}
	}
}