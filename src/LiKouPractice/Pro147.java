package LiKouPractice;

public class Pro147 {
	// 对链表进行插入排序
	public static void main(String args[]) {
		ListNode node1 = new ListNode(-1);
		ListNode node2 = new ListNode(5);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(0);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next=node5;
		Pro147 p = new Pro147();
		System.out.println(p.insertionSortList(node1));
	}

	public ListNode insertionSortList(ListNode head) {
		if (head == null||head.next == null)
			return head;
		ListNode FirstNode = new ListNode(Integer.MIN_VALUE);
		FirstNode.next = head;
		ListNode sNode = FirstNode;
		ListNode eNode = head;
		while (eNode.next != null) {
			ListNode node = eNode.next;
			while (sNode.next.val < node.val && sNode != eNode) {
				sNode = sNode.next;
			}
			if (sNode == eNode) {
				eNode = eNode.next;
				sNode=FirstNode;
				continue;
			}
			ListNode temp1Node = sNode.next;
			ListNode temp2Node = eNode.next;
			sNode.next = eNode.next;
			eNode.next = eNode.next.next;
			temp2Node.next = temp1Node;
			sNode=FirstNode;
		}
		return FirstNode.next;
	}
}
