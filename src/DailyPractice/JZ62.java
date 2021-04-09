package DailyPractice;

import java.util.ArrayList;

public class JZ62 {
	/*
	 * 它或者是一棵空树，或者是具有下列性质的二叉树： 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
	 * 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
	 */
	/*
	 * TreeNode KthNode(TreeNode pRoot, int k) { if (pRoot == null || k <= 0) return
	 * null; sortTree(pRoot); if (k > list.size()) { return null; } return
	 * list.get(k - 1); } ArrayList<TreeNode> list = new ArrayList<>(); private void
	 * sortTree(TreeNode pRoot) { if (pRoot == null) return; sortTree(pRoot.left);
	 * list.add(pRoot); sortTree(pRoot.right); }
	 */
	private TreeNode target = null;
	private int k1 = 0;
	TreeNode KthNode(TreeNode pRoot, int k) {
		k1 = k;
		getKthNode(pRoot);
		return target;
	}
	private void getKthNode(TreeNode pRoot) {
		if (pRoot == null || k1 <= 0) {
			return;
		}
		getKthNode(pRoot.left);
		k1--;
		if (k1 == 0) {
			target = pRoot;
			return;
		}
		getKthNode(pRoot.right);
	}

}
