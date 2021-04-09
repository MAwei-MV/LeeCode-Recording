package DailyPractice;

public class JZ61 {
	String Serialize(TreeNode root) {
		if (root == null)
			return "#!";
		StringBuilder sb = new StringBuilder();
		Serialize2(root, sb);
		return sb.toString();
	}

	void Serialize2(TreeNode root, StringBuilder s) {
		if (root == null) {
			s.append("#!");
			return;
		}
		s.append(root.val);
		s.append("!");
		Serialize2(root.left, s);
		Serialize2(root.right, s);
	}

	TreeNode Deserialize(String str) {
		String[] ss = str.split("!");
		if (ss.length == 0 || ss[0].equals("#"))
			return null;
		return Deserialize2(ss);
	}
	int index = -1;
	TreeNode Deserialize2(String[] strs) {
		index++;
		if (!strs[index].equals("#")) {
			TreeNode root = new TreeNode(0);
			root.val = Integer.parseInt(strs[index]);
			root.left = Deserialize2(strs);
			root.right = Deserialize2(strs);
			return root;
		}
		return null;
	}
}
