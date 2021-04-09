package DailyPractice;

import java.util.ArrayList;

public class JZ62 {
	/*
	 * ��������һ�ÿ����������Ǿ����������ʵĶ������� ���������������գ��������������н���ֵ��С�����ĸ�����ֵ��
	 * ���������������գ��������������н���ֵ���������ĸ�����ֵ��
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
