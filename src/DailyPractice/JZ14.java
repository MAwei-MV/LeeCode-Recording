package DailyPractice;

import java.util.Stack;

public class JZ14 {
	/*利用栈实现
	public ListNode FindKthToTail(ListNode head, int k) {
		Stack<ListNode> stack = new Stack<ListNode>();
		ListNode node = head;
		while (node != null) {
			stack.add(node);
			node = node.next;
		}
		for (int i = 0; i < k - 1; i++) {
			if (!stack.isEmpty()) {
				stack.pop();
			} else {
				return null;
			}
		}
		if (stack.isEmpty() || k == 0) {
			return null;
		}
		return stack.pop();
	}
	*/	public ListNode FindKthToTail(ListNode head, int k) {
		ListNode p = head;
		ListNode q = head;
		if (k <= 0 || head == null) {
			return null;
		}
		for (int i = 0; i < k; i++) {
			if (p == null) {
				return null;
			}
			p = p.next;
		}
		while (p != null) {
			p = p.next;
			q = q.next;
		}
		return q;
	}
}
