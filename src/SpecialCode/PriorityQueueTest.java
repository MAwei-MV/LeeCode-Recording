package SpecialCode;

import java.util.PriorityQueue;

public class PriorityQueueTest {
	public static void main(String args[]) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> a - b);
		int a[] = { 12, 4, 1, 27, 76, 4, 44, 31 };
		for (int i : a) {
			pq.offer(i);
		}
		while (!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}
}
