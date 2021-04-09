package LiKouPractice;

import java.util.ArrayList;
import java.util.List;


public class Pro971 {
	public static void main(String args[]) {
		Pro971 p = new Pro971();
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		int[] a = { 1, 3, 2 };
		node1.left = node2;
		node1.right = node3;
		System.out.println(p.flipMatchVoyage(node1, a));
	}

	List<Integer> list;
	int flag=0;
	public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
		list = new ArrayList<>();
		helper(root, voyage);
		if (!list.isEmpty() && list.get(0) == -1) {
			list.clear();
			list.add(-1);
		}
		return list;
	}

	private void helper(TreeNode node, int[] voyage) {
		if (node != null) {
			if (node.val != voyage[flag++]) {
				list.clear();
				list.add(-1);
				return;
			}
			if (flag <= voyage.length - 1 && node.left != null && node.left.val != voyage[flag]) {
				list.add(node.val);
				helper(node.right, voyage);
				helper(node.left, voyage);
			} else {
				helper(node.left, voyage);
				helper(node.right, voyage);
			}
		}
	}
	/*
	 * List<Integer> flipped; int index; int[] voyage;
	 * 
	 * public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) { flipped =
	 * new ArrayList<>(); index = 0; this.voyage = voyage;
	 * 
	 * dfs(root); if (!flipped.isEmpty() && flipped.get(0) == -1) { flipped.clear();
	 * flipped.add(-1); }
	 * 
	 * return flipped; }
	 * 
	 * public void dfs(TreeNode node) { if (node != null) { if (node.val !=
	 * voyage[index++]) { flipped.clear(); flipped.add(-1); return; }
	 * 
	 * if (index < voyage.length && node.left != null && node.left.val !=
	 * voyage[index]) { flipped.add(node.val); dfs(node.right); dfs(node.left); }
	 * else { dfs(node.left); dfs(node.right); } } }
	 */
}
