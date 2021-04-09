package LiKouPractice;

public class Pro328 {
	public ListNode oddEvenList(ListNode head) {
		if (head == null)
			return null;
		ListNode OddNode = head;
		ListNode firstEvenNode = head.next;
		ListNode EvenNode = head.next;
		while (OddNode.next != null && EvenNode.next != null) {
			OddNode.next = EvenNode.next;
			EvenNode.next = OddNode.next.next;
			OddNode = OddNode.next;
			EvenNode = EvenNode.next;
		}
		OddNode.next = firstEvenNode;
		return head;
	}
}
