package DailyPractice;

public class JZ36 {
	// 节点相等并不是 值相等
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		ListNode node1 = pHead1;
		ListNode node2 = pHead2;
		while (node1 != null) {
			ListNode node = new ListNode(node1.val);
			node.next = node2;
			node2 = node;
			node1 = node1.next;
		}
		ListNode pHead22 = node2;
		node2 = pHead2;
		node1 = pHead1;
		while (node2 != null) {
			ListNode node = new ListNode(node2.val);
			node.next = node1;
			node1 = node;
			node2 = node2.next;
		}
		ListNode pHead11 = node1;
		while (pHead11 != null & pHead22 != null) {
			if(pHead11==pHead22) {
				return pHead11;
			}
			pHead11=pHead11.next;
			pHead22=pHead22.next;
		}
		return null;
	}
}
	/*
	 * 更聪明
	 *  public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
         if(pHead1==null || pHead2==null){
             return null;
         }
        ListNode p1=pHead1;
        ListNode p2=pHead2;
        while(p1!=p2){
            p1=p1.next;
            p2=p2.next;
            if(p1!=p2){
                if(p1==null){
                    p1=pHead2;
                }
                if(p2==null){
                    p2=pHead1;
                }
            }
        }
        return p1;
    }
}
	 */

