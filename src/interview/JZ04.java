package interview;

public class JZ04 {
	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		return helper(pre, 0, pre.length - 1, in, 0, in.length - 1);
	}

	public TreeNode helper(int[] pre, int start1, int end1, int[] in, int start2, int end2) {
		if (end1 < start1) {
			return null;
		}
		if (end1 == start1) {
			return new TreeNode(pre[start1]);
		}
		int flag = pre[start1];
		int index = start2;
		for (; index < end2; index++) {
			if (in[index] == flag) {
				break;
			}
		}
		TreeNode node = new TreeNode(flag);
		node.left = helper(pre, start1 + 1, index - start2 + start1, in, start2, index - 1);
		node.right = helper(pre, index - start2 + start1 + 1, end1, in, index + 1, end2);
		return node;
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
