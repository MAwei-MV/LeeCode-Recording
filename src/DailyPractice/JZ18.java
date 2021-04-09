package DailyPractice;

//while±ðºÍµÝ¹é 
public class JZ18 {
	public void Mirror(TreeNode root) {
		if (root == null) {
			return;
		}
		TreeNode tempNode = root.right;
		root.right = root.left;
		root.left = tempNode;
		Mirror(root.right);
		Mirror(root.left);
	}
}
