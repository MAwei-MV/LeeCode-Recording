package tree;


public class IsBalance {
	/*
	 * class TreeNode { int val; TreeNode left; TreeNode right;
	 * 
	 * TreeNode() { }
	 * 
	 * TreeNode(int val) { this.val = val; }
	 * 
	 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
	 * = left; this.right = right; } }
	 */

	public class Pro110 {
		//自顶向下
		/*
		 * public boolean isBalanced(TreeNode root) { if (root == null) return true;
		 * else { return Math.abs(helper(root.left) - helper(root.right)) <= 1 &&
		 * isBalanced(root.left) && isBalanced(root.right); } }
		 * 
		 * public int helper(TreeNode node) { if (node == null) return 0; return
		 * helper(node.left) > helper(node.right) ? (1 + helper(node.left)) : (1 +
		 * helper(node.right)); }
		 */
		//自底向上
		 public boolean isBalanced(TreeNode1 root) {
		        return height(root) >= 0;
		    }

		    public int height(TreeNode1 root) {
		        if (root == null) {
		            return 0;
		        }
		        int leftHeight = height(root.left);
		        int rightHeight = height(root.right);
		        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
		            return -1;
		        } else {
		            return Math.max(leftHeight, rightHeight) + 1;
		        }
		    }
	}

}
