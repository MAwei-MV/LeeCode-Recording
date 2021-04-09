package DailyPractice;
//µ¹×ªÁ´±í
public class JZ15 {
	public ListNode ReverseList(ListNode head) {
		ListNode pre = null;
		ListNode node = head;
		ListNode NewHeadNode =null;
		if (head == null) {
			return null;
		}
		while (node != null) {
			ListNode tempNode = node.next;
			if(tempNode == null) {
				NewHeadNode =node;
			}
			node.next = pre;
			pre = node;
			node = tempNode;
		}
		return NewHeadNode;
	}
}
