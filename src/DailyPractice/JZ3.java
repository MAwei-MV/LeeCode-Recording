package DailyPractice;

import java.util.ArrayList;
import java.util.Stack;

class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}

public class JZ3 {
/*�ǵݹ�
		public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> list = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();// java����
		while (listNode != null) {
			stack.add(listNode.val);
			listNode = listNode.next;
		}
		while (!stack.isEmpty()) {
			list.add(stack.pop());
		}
		return list;
	}
*/
	//�ݹ�
	ArrayList<Integer> list = new ArrayList<>();
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		if(listNode != null) {
			printListFromTailToHead(listNode.next);
			list.add(listNode.val);
		}
		return list;
}
}
