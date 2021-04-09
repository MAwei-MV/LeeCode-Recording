package tree;

import java.util.LinkedList;

public class LevelPrint {
	public static void levelPrint(TreeNode1 root) {
		if (root == null) {
			return;
		}
		LinkedList<TreeNode1> queue = new LinkedList<TreeNode1>();
		TreeNode1 current = null;
		queue.offer(root);// �����ڵ����
		while (!queue.isEmpty()) {
			current = queue.poll();// ���Ӷ�ͷԪ�ز�����
			System.out.println(current.val);
			if (current.left != null)// �����ǰ�ڵ����ڵ㲻Ϊ�����
			{
				queue.offer(current.left);
			}
			if (current.right != null)// �����ǰ�ڵ���ҽڵ㲻Ϊ�գ����ҽڵ����
			{
				queue.offer(current.right);
			}
		}

	}
}
