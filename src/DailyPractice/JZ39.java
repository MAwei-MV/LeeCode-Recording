package DailyPractice;

public class JZ39 {
	public boolean IsBalanced_Solution(TreeNode root) {
		if (root == null)
			return true;
		if (Math.abs(depth(root.left) - depth(root.right)) > 1) {
			return false;
		}
		return IsBalanced_Solution(root.right) & IsBalanced_Solution(root.left);
	}

	private int depth(TreeNode root) {
		if (root == null)
			return 0;
		else if (root.left == null && root.right == null)
			return 1;
		else if (root.left != null && root.right == null)
			return 1 + depth(root.left);
		else if (root.right != null && root.left == null)
			return 1 + depth(root.right);
		else
			return depth(root.right) > depth(root.left) ? depth(root.right) + 1 : depth(root.left) + 1;

	}
}
