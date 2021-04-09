package LiKouPractice;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class Pro110 {
	// 自顶向下
	/*
	 * public boolean isBalanced(TreeNode root) { if (root == null) return true;
	 * else { return Math.abs(helper(root.left) - helper(root.right)) <= 1 &&
	 * isBalanced(root.left) && isBalanced(root.right); } }
	 * 
	 * public int helper(TreeNode node) { if (node == null) return 0; return
	 * helper(node.left) > helper(node.right) ? (1 + helper(node.left)) : (1 +
	 * helper(node.right)); }
	 */
	// 自底向上
	public boolean isBalanced(TreeNode root) {
		return helper(root) != -1;
	}

	private int helper(TreeNode root) {
		if (root == null)
			return 0;
		int temp1 = helper(root.left);
		if (temp1 == -1)
			return -1;
		int temp2 = helper(root.right);
		if (temp2 == -1)
			return -1;
		return Math.abs(temp1 - temp2) >= 2 ? -1 : Math.max(temp1, temp2)+1;

	}

}