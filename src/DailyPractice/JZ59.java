package DailyPractice;

import java.util.ArrayList;
import java.util.Stack;

public class JZ59 {
	ArrayList<ArrayList<Integer>> ll = new ArrayList<>();
	Stack<TreeNode> s = new Stack<>();
	int level = 1;

	public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<TreeNode> a = new ArrayList<>();
		if (pRoot == null)
			return ll;
		a.add(pRoot);
		ll.clear();
		p(a);
		return ll;
	}
	public void p(ArrayList<TreeNode> list) {
		if (list == null || list.isEmpty())
			return;
		ArrayList<TreeNode> newList = new ArrayList<>();
		ArrayList<Integer> l = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			s.add(list.get(i));
			l.add(list.get(i).val);
		}
		while (!s.isEmpty()) {
			if (level % 2 == 1) {
				if (s.peek().right != null)
					newList.add(s.peek().right);
				if (s.peek().left != null)
					newList.add(s.peek().left);
			} else {
				if (s.peek().left != null)
					newList.add(s.peek().left);
				if (s.peek().right != null)
					newList.add(s.peek().right);
			}
			s.pop();
		}
		level++;
		ll.add(l);
		p(newList);
	}
}
