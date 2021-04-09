package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeTraverse {
//�����������ܽ�
	public void Traverse(TreeNode1 root) {
		// �����ڵ�����List������
		List<TreeNode1> sortNodes = new ArrayList<>();
		// ǰ
		preOrderTraversal(root, sortNodes);
		// ��
		inOrderTraversal(root, sortNodes);
		// ��
		postOrderTraversal(root, sortNodes);
	}

//1.ǰ�����
	public void preOrderTraversal(TreeNode1 node, List<TreeNode1> sortNodes) {
		if (node != null) {
			return;
		}
		sortNodes.add(node);
		preOrderTraversal(node.left, sortNodes);
		preOrderTraversal(node.right, sortNodes);
	}

//2.�������
	public void inOrderTraversal(TreeNode1 node, List<TreeNode1> sortNodes) {
		if (node == null) {
			return;
		}
		inOrderTraversal(node.left, sortNodes);
		sortNodes.add(node);
		inOrderTraversal(node.right, sortNodes);
	}

//3.�������
	public void postOrderTraversal(TreeNode1 node, List<TreeNode1> sortNodes) {
		if (node == null) {
			return;
		}
		postOrderTraversal(node.left, sortNodes);
		postOrderTraversal(node.right, sortNodes);
		sortNodes.add(node);
	}

//�ǵݹ�д��һ�����õ�ջ��
//1.1ǰ������ǵݹ�
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

//2.1��������ǵݹ�
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

//3.1��������ǵݹ�
	//��ס
	// ���ø���ջʵ��
	// 1.�ȰѸ��ڵ�ѹ�븨��ջ
	// 2.Ȼ��ѭ�����жϸ���ջ�Ƿ�Ϊ�գ������Ϊ�գ���ջ��Ԫ��Ѻ����ջ
	// ͬʱ�������ҽڵ�ģ��ֱ�ѹ�����ҽڵ㵽����ջ
	// 3.�����ջ����������ջ˳���ӡ�ڵ���Ϣ���õ��ı��Ǻ�������ڵ�˳��
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
