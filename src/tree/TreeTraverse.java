package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeTraverse {
//二叉树遍历总结
	public void Traverse(TreeNode1 root) {
		// 遍历节点存放至List数组中
		List<TreeNode1> sortNodes = new ArrayList<>();
		// 前
		preOrderTraversal(root, sortNodes);
		// 中
		inOrderTraversal(root, sortNodes);
		// 后
		postOrderTraversal(root, sortNodes);
	}

//1.前序遍历
	public void preOrderTraversal(TreeNode1 node, List<TreeNode1> sortNodes) {
		if (node != null) {
			return;
		}
		sortNodes.add(node);
		preOrderTraversal(node.left, sortNodes);
		preOrderTraversal(node.right, sortNodes);
	}

//2.中序遍历
	public void inOrderTraversal(TreeNode1 node, List<TreeNode1> sortNodes) {
		if (node == null) {
			return;
		}
		inOrderTraversal(node.left, sortNodes);
		sortNodes.add(node);
		inOrderTraversal(node.right, sortNodes);
	}

//3.后序遍历
	public void postOrderTraversal(TreeNode1 node, List<TreeNode1> sortNodes) {
		if (node == null) {
			return;
		}
		postOrderTraversal(node.left, sortNodes);
		postOrderTraversal(node.right, sortNodes);
		sortNodes.add(node);
	}

//非递归写法一定会用到栈。
//1.1前序遍历非递归
	public void preOrderStackTraversal(TreeNode1 root, List<TreeNode1> list) {
		Stack<TreeNode1> stack = new Stack<>();
		TreeNode1 node1 = root;
		while (node1 != null || !stack.isEmpty()) {
			while (node1 != null) {
				list.add(node1);
				stack.push(node1);
				node1 = node1.left;
			}
			if (!stack.isEmpty()) {
				node1 = stack.pop();
				node1 = node1.right;
			}
		}
	}

//2.1中序遍历非递归
	public void midOrderStackTraveral(TreeNode1 root, List<TreeNode1> list) {
		Stack<TreeNode1> stack = new Stack<>();
		TreeNode1 node1 = root;
		while (node1 != null || !stack.isEmpty()) {
			while (node1 != null) {
				stack.push(node1);
				node1 = node1.left;
			}
			if (!stack.isEmpty()) {
				node1 = stack.pop();
				list.add(node1);
				node1 = node1.right;
			}
		}
//		TreeNode1 treeNode = root;
//		while (treeNode != null || !stack.isEmpty()) {
//			while (treeNode != null) {
//				stack.push(treeNode);
//				treeNode = treeNode.left;
//			}
//			if (!stack.isEmpty()) {
//				treeNode = stack.pop();
//				list.add(treeNode);
//				treeNode = treeNode.right;
//			}
//		}

	}

//3.1后序遍历非递归
	//记住
	// 利用辅助栈实现
	// 1.先把根节点压入辅助栈
	// 2.然后循环，判断辅助栈是否为空，如果不为空，则栈顶元素押入主栈
	// 同时存在左右节点的，分别压入左右节点到辅助栈
	// 3.最后主栈遍历，按出栈顺序打印节点信息，得到的便是后序遍历节点顺序
	public void postOrderStackTraversal(TreeNode1 root, List<TreeNode1> list) {
		if (root == null) {
			return;
		}
		Stack<TreeNode1> stack = new Stack<>();
		Stack<TreeNode1> stack1 = new Stack<>();
		TreeNode1 node = root;
		stack1.push(node);
		while (!stack1.isEmpty()) {
			node = stack1.pop();
			stack.push(node);
			if (node.left != null) {
				stack1.push(node.left);
			}
			if (node.right != null) {
				stack1.push(node.right);
			}
		}
		while (!stack.isEmpty()) {
			node = stack.pop();
			list.add(node);
		}
	}
}
