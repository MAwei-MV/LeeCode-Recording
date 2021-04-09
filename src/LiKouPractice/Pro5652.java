package LiKouPractice;

public class Pro5652 {
	public static void main(String args[]) {
		Pro5652 p =new Pro5652();
		ListNode node1=new ListNode(1);
		ListNode node2=new ListNode(2);
		node1.next=node2;

		System.out.println(p.swapNodes(node1, 2));
	}
	public ListNode swapNodes(ListNode head, int k) {
		if (head.next == null)
			return head;
		ListNode startNode = head;
		ListNode endNode = null;
		ListNode index1Node = null;
		ListNode index2Node = null;
		ListNode blockNode=new ListNode();
		blockNode.next=head;
		int flag = 2;
		if(k==1) index1Node=blockNode;
		else {
		while (startNode.next != null) {
			if (flag == k) {
				index1Node = startNode;
				break;
			}
			startNode=startNode.next;
			flag++;
		}
		}
		startNode = blockNode;
		flag = 1;
		while (startNode != null) {
			if (flag - k - 1 >= 0) {
				if(endNode==null) endNode=blockNode;
				else {
					endNode = endNode.next;
				}
			}
			if (startNode.next == null) {
				index2Node = endNode;
			}
			startNode=startNode.next;
			flag++;
		}
		ListNode f11 = index1Node.next;
		ListNode f12 = f11.next;
		ListNode f21 = index2Node.next;
		ListNode f22 = f21.next;
		if(f11.next==f21) {
			index1Node.next=f21;
			f11.next=f21.next;
			f21.next=f11;
		}
		else if(f21.next==f11) {
			index2Node.next=f11;
			f21.next=f11.next;
			f11.next=f21;
		}
		else {
			index1Node.next = f21;
			f21.next = f12;
			index2Node.next = f11;
			f11.next = f22;
		}
		return blockNode.next;
	}
}
