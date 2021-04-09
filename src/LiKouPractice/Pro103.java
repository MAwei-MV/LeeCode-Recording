/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
package LiKouPractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//æ‚≥›–Œ≈≈–Ú
public class Pro103 {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> ll = new ArrayList<>();
		if(root==null) return ll;
		Queue<TreeNode> q = new LinkedList<>();
		boolean flag = true;
		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size();
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				if (flag)
					list.add(node.val);
				else
					list.add(0, node.val);
				if (node.left != null)
					q.add(node.left);
				if (node.right != null)
					q.add(node.right);
			}
			ll.add(list);
			flag = !flag;
		}
		return ll;
	}
}
