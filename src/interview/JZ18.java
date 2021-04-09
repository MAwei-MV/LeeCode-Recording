package interview;


public class JZ18 {
	public TreeNode Mirror(TreeNode pRoot) {
		if (pRoot == null)
			return null;
		TreeNode node = pRoot.left;
		pRoot.left = pRoot.right;
		pRoot.right = node;
		Mirror(pRoot.left);
		Mirror(pRoot.right);
		return pRoot;
	}

	class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;

		public TreeNode(int val) {
			this.val = val;
		}
	}
}
