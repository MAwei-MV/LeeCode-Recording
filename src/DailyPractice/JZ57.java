package DailyPractice;

class TreeLinkNode {
	int val;
	TreeLinkNode left = null;
	TreeLinkNode right = null;
	TreeLinkNode next = null;

	TreeLinkNode(int val) {
		this.val = val;
	}
}

public class JZ57 {
	public TreeLinkNode GetNext(TreeLinkNode pNode) {
		if (pNode == null)
			return null;
		if (pNode.next == null && pNode.right == null) {
			return null;
		} else if (pNode.next != null && pNode.right == null && pNode.next.left == pNode) {
			return pNode.next;
		} else if (pNode.next != null && pNode.right == null && pNode.next.right == pNode) {
			TreeLinkNode node=pNode.next;
			while(node.next!=null) {
				if(node.next.left == node)return node.next;
				node=node.next;
			}
			return null;
		} else {
			TreeLinkNode node = pNode.right;
			while (node.left != null) {
				node = node.left;
			}
			return node;
		}
	}
}
