package DailyPractice;
//考虑树节点的val值相同，递归
class TreeNode1 {
	int val = 0;
	TreeNode1 left = null;
	TreeNode1 right = null;

	public TreeNode1(int val) {
		this.val = val;
	}
}

public class JZ17 {
	public boolean HasSubtree(TreeNode1 root1, TreeNode1 root2) {
		if (root1 == null || root2 == null) {
			return false;
		} 
			if (root1.val == root2.val) {
				if (judge(root1, root2)) {
					return true;
				};
			} 
				return (HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2));
	}

	public boolean judge(TreeNode1 root1, TreeNode1 root2) {
		if (root2 == null) {
			return true;
		} else if (root1 == null || root1.val != root2.val) {
			return false;
		} else {
			return judge(root1.left, root2.left) && judge(root1.right, root2.right);
		}
	}
}
