package DailyPractice;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class JZ64 {
	public PriorityQueue<Integer> maxQueue = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);// �󶥶�
	public ArrayList<Integer> result = new ArrayList<Integer>();// ������

	public ArrayList<Integer> maxInWindows(int[] num, int size) {
		if (num == null || num.length <= 0 || size <= 0 || size > num.length) {
			return result;
		}
		int count = 0;
		for (; count < size; count++) {// ��ʼ����������
			maxQueue.offer(num[count]);
		}
		while (count < num.length) {// ��ÿ�β������ҵ����ֵ�������ȶ��еĴ󶥶ѣ���Ȼ����󻬶�������һ�������һ����
			result.add(maxQueue.peek());
			maxQueue.remove(num[count - size]);
			maxQueue.add(num[count]);
			count++;
		}
		result.add(maxQueue.peek());// ���һ����Ѻ�û�����������������һ�μ���
		return result;
	}
}
