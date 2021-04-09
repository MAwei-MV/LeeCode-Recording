package tree;

import java.util.LinkedList;

public class LevelPrint {
	public static void levelPrint(TreeNode1 root) {
		if (root == null) {
			return;
		}
		LinkedList<TreeNode1> queue = new LinkedList<TreeNode1>();
		TreeNode1 current = null;
		queue.offer(root);// 将根节点入队
		while (!queue.isEmpty()) {
			current = queue.poll();// 出队队头元素并访问
			System.out.println(current.val);
			if (current.left != null)// 如果当前节点的左节点不为空入队
			{
				queue.offer(current.left);
			}
			if (current.right != null)// 如果当前节点的右节点不为空，把右节点入队
			{
				queue.offer(current.right);
			}
		}

	}
}
