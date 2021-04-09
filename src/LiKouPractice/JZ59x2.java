package LiKouPractice;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class JZ59x2 {
	/*
	 * Queue<Integer> q; Deque<Integer> d;
	 * 
	 * public JZ59x2() { q = new LinkedList<Integer>(); d = new
	 * LinkedList<Integer>(); }
	 * 
	 * public int max_value() { if (d.isEmpty()) { return -1; } return
	 * d.peekFirst(); }
	 * 
	 * public void push_back(int value) { while (!d.isEmpty() && d.peekLast() <
	 * value) { d.pollLast(); } d.offerLast(value); q.offer(value); }
	 * 
	 * public int pop_front() { if (q.isEmpty()) { return -1; } int ans = q.poll();
	 * if (ans == d.peekFirst()) { d.pollFirst(); } return ans; }
	 */
	//双端队列，“double ended queue（双端队列）
	Deque<Integer> d;

	Queue<Integer> q;

	public JZ59x2() {
		d = new LinkedList<>();
		q = new LinkedList<>();
	}

	public int max_value() {
		if (q.isEmpty())
			return -1;
		else {
			return d.peekFirst();
		}
	}

	public void push_back(int value) {
		while (!d.isEmpty() && d.peekLast() < value) {
			d.pollLast();
		}
		q.offer(value);
		d.offer(value);
	}

	public int pop_front() {
		if (q.isEmpty())
			return -1;
		int value = q.poll();
		if (d.peekFirst() == value)
			d.pollFirst();
		return value;
	}
}