package DailyPractice;

import java.util.HashMap;

public class JZ56 {

	public static void main(String args[]) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(3);
		ListNode node5 = new ListNode(4);
		ListNode node6 = new ListNode(5);
		ListNode node7 = new ListNode(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		JZ56 j = new JZ56();
		System.out.println(j.deleteDuplication(node1));
	}

	/*
	 * public ListNode deleteDuplication(ListNode pHead) { if (pHead == null) return
	 * null; ListNode node = pHead; HashMap<Integer, Integer> m = new HashMap<>();
	 * while (node != null) { if (!m.containsKey(node.val)) { m.put(node.val, 1); }
	 * else { int value = m.get(node.val); m.replace(node.val, value + 1); } node =
	 * node.next; } node = pHead; ListNode h = null; ListNode n = null; while (node
	 * != null) { if (m.get(node.val) == 1) { if (h == null) { h = node; n = node; }
	 * else { n.next = node; n = node; } } node = node.next; } if (n != null) n.next
	 * = null; return h; }
	 */
	public ListNode deleteDuplication(ListNode pHead) {
		if (pHead == null || pHead.next == null) {
			return pHead;
		}
		ListNode head = new ListNode(0);
		head.next = pHead;
		ListNode pre = head;
		ListNode last = head.next;
		while (last != null) {
			if (last.next != null && last.val == last.next.val) {
				while (last.next != null && last.val == last.next.val) {
					last = last.next;
				}
				pre.next = last.next;
				last = last.next;
			} else {
				pre = pre.next;
				last = last.next;
			}
		}
		return head.next;
	}
}
