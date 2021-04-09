package DailyPractice;

class RandomListNode {
	int label;
	RandomListNode next = null;
	RandomListNode random = null;

	RandomListNode(int label) {
		this.label = label;
	}
}

/*
 * 解题思路： 1、遍历链表，复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
 * 2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next; 3、拆分链表，将链表拆分为原链表和复制后的链表
 */
public class JZ25 {// 深拷贝？
	public RandomListNode Clone(RandomListNode pHead) {
		if(pHead == null) return null;
		RandomListNode node = pHead;
		while (node != null) {
			RandomListNode cloneNode = new RandomListNode(node.label);
			cloneNode.next = node.next;
			node.next = cloneNode;
			node = cloneNode.next;
		}
		node = pHead;
		while (node != null) {
			if(node.random != null) {
				node.next.random = node.random.next;
			}
			node = node.next.next;
		}
		node = pHead;
		RandomListNode root=pHead.next;
		RandomListNode temp=root;
		while (node != null) {
			node.next=temp.next;
			temp.next=node.next== null?null : node.next.next;
			node=node.next;
			temp=temp.next;
		}
		return root;
	}
}
