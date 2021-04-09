package LiKouPractice;

public class Pro21 {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode node1 = l1;
		ListNode node2 = l2;
		ListNode headNode = new ListNode();
		ListNode node = headNode;
		while (node1 != null && node2 != null) {
			if (node1.val >= node2.val) {
				node.next = node2;
				node2 = node2.next;
			} else {
				node.next = node1;
				node1 = node1.next;
			}
			node = node.next;
		}
		while (node1 != null) {
			node.next = node1;
			node1 = node1.next;
			node = node.next;
		}
		while (node2 != null) {
			node.next = node2;
			node2 = node2.next;
			node = node.next;
		}
		return headNode.next;
	}
}
