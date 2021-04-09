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
		// 判断间隔内的空间能不能放下除了<第一个><最多>次数字母以外的字母
		int space = n * (max - 1) - (maxCount - 1) - (tasks.length - maxCount * max);
		// 如果放不下，说明原数组长度就是结果
		if (space < 0) {
			return tasks.length;
		} else {
			// 如果放得下，就是第一个最多次数字母的长度，再加上和他次数相等的字母数量
			return n * (max - 1) + max + maxCount - 1;
		}
	}
}