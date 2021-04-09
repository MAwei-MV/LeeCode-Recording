package LiKouPractice;

import java.util.LinkedList;
import java.util.Queue;

public class Pro222 {
	/*
	 * public int countNodes(TreeNode root) { Queue<TreeNode> queue = new
	 * LinkedList<>(); if (root == null) return 0; queue.offer(root); int sum = 0;
	 * while (!queue.isEmpty()) { if (queue.peek().left != null) {
	 * queue.offer(queue.peek().left); } if (queue.peek().right != null) {
	 * queue.offer(queue.peek().right); } queue.poll(); sum++; } return sum; }
	 */
	// 利用完全二叉树的特点
	public int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = countLevel(root.left);
		int right = countLevel(root.right);
		if (left == right) {
			return countNodes(root.right) + (1 << left);
		} else {
			return countNodes(root.left) + (1 << right);
		}
	}

	private int countLevel(TreeNode root) {
		int level = 0;
		while (root != null) {
			level++;
			root = root.left;
		}
		return level;
	}
}
