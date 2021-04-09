package DailyPractice;

import java.util.HashSet;
import java.util.Set;

//数学解题
public class JZ55 {
	/*
	 * public ListNode EntryNodeOfLoop(ListNode pHead) { ListNode node1 = pHead;
	 * ListNode node2 = pHead; if (pHead == null || pHead.next == null) return null;
	 * do { node1 = node1.next; node2 = node2.next.next; } while (node1 != node2 &&
	 * node2 != null); if (node2 == null) return null; node2 = pHead; while (node1
	 * != node2) { node1 = node1.next; node2 = node2.next; } return node1; }
	 */
	public ListNode EntryNodeOfLoop(ListNode pHead) {
		Set<ListNode> set = new HashSet<>();
		ListNode node = pHead;
		while (node != null) {
			if (set.contains(node)) {
				break;
			}
			set.add(node);
			node = node.next;
		}
		return node;
	
	}
}
