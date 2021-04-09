package DailyPractice;

import java.util.ArrayList;
import java.util.Stack;

public class JZ24 {// ���ᣬ�࿴,�븴���ˣ���������·�����壺�Ӹ��ڵ� �� Ҷ�ӽڵ�
	private ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
	private Stack<Integer> path = new Stack<Integer>();
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
		if (root == null)
			return paths;
		path.push(root.val);
		target = target - root.val;
		if (target == 0 && root.left == null & root.right == null) {
			paths.add(new ArrayList<Integer>(path)); // ?
		}
		FindPath(root.left, target);
		FindPath(root.right, target);
		path.pop();
		return paths;// ?
	}
}
