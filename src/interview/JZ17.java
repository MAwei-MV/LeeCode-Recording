package interview;

import java.util.LinkedList;
import java.util.Queue;

public class JZ17 {
	public boolean HasSubtree(TreeNode root1, TreeNode root2) {
		if (root2 == null || root1 == null) {
			return false;
		}
		Boolean res = false;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root1);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node.left != null)
				queue.add(node.left);
			if (node.right != null)
				queue.add(node.right);
			if (node.val == root2.val) {
				if (helper(node, root2))
					return res;
			}
		}
		return false;
	}

	private Boolean helper(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 == null)
			return false;
		if (root2 == null)
			return true;
		if (root1.val != root2.val) {
			return false;
		}
		return helper(root1.left, root2.left) & helper(root1.right, root2.right);
	}

	public class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;

		public TreeNode(int val) {
			this.val = val;
		}
	}
}
