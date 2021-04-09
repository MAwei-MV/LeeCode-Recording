package DailyPractice;

import java.util.Arrays;
import java.util.Scanner;

//递归
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

//有参构造
	TreeNode(int x) {
		val = x;
	}
}

public class JZ4 {
	public static void main(String args[]) {
		JZ4 j = new JZ4();
		Scanner sc = new Scanner(System.in);
		String array1 = sc.next();
		String array2 = sc.next();
		System.out.println(array1 + "+" + array2);
		String handlearray1 = array1.substring(1, array1.length() - 1);
		String handlearray2 = array2.substring(1, array2.length() - 1);
		String[] pre1 = handlearray1.split(",");
		String[] in1 = handlearray2.split(",");
		int[] pre2 = new int[pre1.length];
		int[] in2 = new int[in1.length];
		for (int i = 0; i < pre1.length; i++) {
			pre2[i] = Integer.parseInt(pre1[i]);
			in2[i] = Integer.parseInt(in1[i]);
		}
		System.out.println(j.reConstructBinaryTree(pre2, in2));
	}

	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		if (pre.length == 0 || in.length == 0) {
			return null;
		} else {
			TreeNode tree = new TreeNode(pre[0]);
			for (int i = 0; i < in.length; i++) {
				if (in[i] == pre[0]) {
					tree.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
					tree.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length),
							Arrays.copyOfRange(in, i + 1, in.length));
				}
			}
			return tree;
		}
	}
}
