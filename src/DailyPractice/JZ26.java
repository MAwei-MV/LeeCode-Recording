package DailyPractice;

import java.util.ArrayList;

public class JZ26 {
	static ArrayList<TreeNode> resultList = new ArrayList<>();

	public TreeNode Convert(TreeNode pRootOfTree) {
		if (pRootOfTree == null) {
			return null;
		}
		// ������̬Listʱ�ǵ���ղ�������
		resultList.clear();
		Convert1(pRootOfTree);
		return addPointer(resultList);
	}

	// �������
	public void Convert1(TreeNode root) {
		if (root != null)
			Convert1(root.left);
		resultList.add(root);
		Convert1(root.right);
	}

	// ��ָ��
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
