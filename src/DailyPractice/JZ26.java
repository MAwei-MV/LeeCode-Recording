package DailyPractice;

import java.util.ArrayList;

public class JZ26 {
	static ArrayList<TreeNode> resultList = new ArrayList<>();

	public TreeNode Convert(TreeNode pRootOfTree) {
		if (pRootOfTree == null) {
			return null;
		}
		// 声明静态List时记得清空测试用例
		resultList.clear();
		Convert1(pRootOfTree);
		return addPointer(resultList);
	}

	// 中序遍历
	public void Convert1(TreeNode root) {
		if (root != null)
			Convert1(root.left);
		resultList.add(root);
		Convert1(root.right);
	}

	// 加指针
	public TreeNode addPointer(ArrayList<TreeNode> list) {
		TreeNode preNode = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			preNode.right = list.get(i);
			list.get(i).left = preNode;
			preNode = list.get(i);
		}
		return list.get(0);
	}
}
