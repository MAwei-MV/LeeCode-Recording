package DailyPractice;

import java.util.ArrayList;
import java.util.LinkedList;

public class JZ60 {
	ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		ArrayList<ArrayList<Integer>> ll = new ArrayList<>();
		if (pRoot == null) {
			return ll;
		}
		TreeNode current = null;
		queue.offer(pRoot);
		ArrayList<Integer> l;
		ArrayList<Integer> list1 = new ArrayList<>();
		l = list1;
		while (!queue.isEmpty()) {
			int x = queue.size();
			for (int i = 0; i < x; i++) {
				current = queue.poll();
				l.add(current.val);
				if (current.left != null)
					queue.offer(current.left);
				if (current.right != null)
					queue.offer(current.right);
			}
			ArrayList<Integer> list = new ArrayList<>();
			ll.add(l);
			l = list;
		}
		return ll;
	}
}
