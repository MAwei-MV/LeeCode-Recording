package LiKouPractice;

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

public class Pro2 {
	public static void main(String args[]) {
		ListNode node0 = new ListNode(9);
		ListNode node1 = new ListNode(9);
		ListNode node2 = new ListNode(9);
		ListNode node3 = new ListNode(9);
		ListNode node4 = new ListNode(9);
		ListNode node5 = new ListNode(9);
		ListNode node6 = new ListNode(9);
		ListNode node7 = new ListNode(9);
		ListNode node8 = new ListNode(9);
		ListNode node9 = new ListNode(9);
		node0.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node6.next = node7;
		node7.next = node8;
		node8.next = node9;
		Pro2 p = new Pro2();
		System.out.println(p.addTwoNumbers(node0, node6));
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode resultNode = null;
		ListNode node1 = l1;
		ListNode node2 = l2;
		ListNode beforNode = null;
		int flag = 0;
		int s = 0;
		while (node1 != null || node2 != null) {
			if (node1 != null && node2 != null) {
				ListNode node = new ListNode((node1.val + node2.val + flag) % 10);
				if (s == 0) {
					resultNode = node;
					s++;
					beforNode = node;
				} else {
					beforNode.next = node;
					beforNode = node;
				}
				flag = (node1.val + node2.val + flag) / 10;
				node1 = node1.next;
				node2 = node2.next;
			} else if (node1 == null) {
				ListNode node = new ListNode((node2.val + flag) % 10);
				flag = (node2.val + flag) / 10;
				beforNode.next = node;
				beforNode = node;
				node2 = node2.next;
			} else {
				ListNode node = new ListNode((node1.val + flag) % 10);
				flag = (node1.val + flag) / 10;
				beforNode.next = node;
				beforNode = node;
				node1 = node1.next;
			}
		}
		//最后有进位则补1
		if (flag == 1)
			beforNode.next = new ListNode(1);
		return resultNode;
	}
}
