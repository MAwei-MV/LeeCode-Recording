package DailyPractice;

/*import java.util.ArrayList;
import java.util.List;
import java.util.Stack;*/

public class JZ58 {
	// Ͷ��ȡ�ɲ���ȡ
	/*
	 * static List<TreeNode> l = new ArrayList<>(); public boolean
	 * isSymmetrical(TreeNode pRoot) { if (pRoot == null) return true; l.clear();
	 * inOrderRecur(pRoot); Stack<TreeNode> s = new Stack<>(); for (TreeNode t : l)
	 * { s.add(t); } for (int i = 0; i < l.size(); i++) { if (s.pop().val !=
	 * l.get(i).val) { return false; } } return true; } public void
	 * inOrderRecur(TreeNode root) { if (root == null) { return; } if (root.left !=
	 * null && root.right == null) { root.right = new TreeNode(999); } if (root.left
	 * == null && root.right != null) { root.left = new TreeNode(999); }
	 * inOrderRecur(root.left); l.add(root); inOrderRecur(root.right); }
	 */
	/*���������Գƶ�����ʵ�����жϣ�
	 * ���ڵ�����ҽڵ�ֵ�Ƿ���ȣ�
	 * ��ڵ�����ӽڵ���ҽڵ�����ӽڵ��Ƿ�ֵ��ȣ�
	 * ��ڵ�����ӽڵ���ҽڵ�����ӽڵ��Ƿ�ֵ��ȣ�
	 */
	public boolean isSymmetrical(TreeNode pRoot) {
		return isSame(pRoot, pRoot);
	}
	public boolean isSame(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 == null || root2 == null)
			return false;
		return root1.val == root2.val && isSame(root1.left, root2.right) && isSame(root1.right, root2.left);
	}
}
