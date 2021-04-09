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
 * ����˼·�� 1��������������ÿ����㣬�縴�ƽ��A�õ�A1�������A1�嵽���A���棻
 * 2�����±������������Ͻ������ָ����½�㣬��A1.random = A.random.next; 3�����������������Ϊԭ����͸��ƺ������
 */
public class JZ25 {// �����
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
