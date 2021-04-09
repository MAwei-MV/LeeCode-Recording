package DailyPractice;

import java.util.ArrayList;
import java.util.LinkedList;
//队列实现Tree的层排序
public class JZ22 {
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<>();
		if (root == null)
			return list;
		// 用链表生成队列
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			list.add(queue.pop().val);
			if (root.left != null) {
				queue.add(root.left);
			}
			if (root.right != null) {
				queue.add(root.right);
			}
			if (!queue.isEmpty()) {
				root = queue.peek();
			}
		}
		return list;
	}
}
