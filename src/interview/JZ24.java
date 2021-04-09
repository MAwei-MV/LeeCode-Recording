package interview;

import java.util.ArrayList;
import java.util.Scanner;

public class JZ24 {
	ArrayList<ArrayList<Integer>> res = new ArrayList<>();

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String t = sc.nextLine();
		String s1 = s.substring(1, s.length() - 1);
		String[] str = s1.split(",");
		int target = Integer.parseInt(t);
		// ½¨Á¢¶þ²æÊ÷
		TreeNode root = new TreeNode(Integer.parseInt(str[0]));
		JZ24 j = new JZ24();
		int res[] = j.FindPath(root, target);
		for (int i = 0; i < res.length; i++) {
			if (i == 0)
				System.out.print("[" + res[0]);
			if (i == res.length - 1) {
				System.out.println("," + res[i] + "]");
			}
			System.out.println("," + res[i]);
		}

	}

	public int[] FindPath(TreeNode root, int target) {
		if (root == null)
			return new int[0];
		ArrayList<Integer> list = new ArrayList<>();
		helper(root, target, list);
		if (res.size() == 0)
			return null;
		int len = Integer.MAX_VALUE;
		for (ArrayList<Integer> list2 : res) {
			if (list2.size() < len)
				len = list2.size();
		}
		int[] r = new int[len];
		for (ArrayList<Integer> list2 : res) {
			if (list2.size() == len) {
				int index = 0;
				for (int i : list2) {
					r[index] = i;
					index++;
				}
				break;
			}
		}
		return r;
	}

	private void helper(TreeNode node, int target, ArrayList<Integer> list) {
		ArrayList<Integer> list1 = new ArrayList<>();
		for (int index : list) {
			list1.add(index);
		}
		list1.add(node.val);
		if (node.left == null && node.right == null && target - node.val == 0) {
			res.add(list1);
		}

		if (node.left != null) {
			helper(node.left, target - node.val, list1);
		}
		if (node.right != null) {
			helper(node.right, target - node.val, list1);
		}
	}

}

class TreeNode {
	TreeNode left;
	TreeNode right;
	int val;

	public TreeNode(int val) {
		this.val = val;
	}
}
