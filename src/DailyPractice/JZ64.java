package DailyPractice;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class JZ64 {
	public PriorityQueue<Integer> maxQueue = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);// 大顶堆
	public ArrayList<Integer> result = new ArrayList<Integer>();// 保存结果

	public ArrayList<Integer> maxInWindows(int[] num, int size) {
		if (num == null || num.length <= 0 || size <= 0 || size > num.length) {
			return result;
		}
		int count = 0;
		for (; count < size; count++) {// 初始化滑动窗口
			maxQueue.offer(num[count]);
		}
		while (count < num.length) {// 对每次操作，找到最大值（用优先队列的大顶堆），然后向后滑动（出堆一个，入堆一个）
			result.add(maxQueue.peek());
			maxQueue.remove(num[count - size]);
			maxQueue.add(num[count]);
			count++;
		}
		result.add(maxQueue.peek());// 最后一次入堆后没保存结果，这里额外做一次即可
		return result;
	}
}
