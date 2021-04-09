package DailyPractice;
/*递归三步：
 * 1.明确函数目的；
 * 2.明确结束条件；
 * 3.找到等价关系。
 */
public class JZ38 {
	public int TreeDepth(TreeNode root) {
		if (root == null)
			return 0;
		if (root.right == null && root.left == null) {
			return 1;
		} else if (root.right != null && root.left == null)
			return TreeDepth(root.right) + 1;
		else if (root.left != null && root.right == null)
			return TreeDepth(root.left) + 1;
		else {
			return TreeDepth(root.left) > TreeDepth(root.right) ? TreeDepth(root.left) + 1 : TreeDepth(root.right) + 1;
		}
	}
	/*
	 *  public int TreeDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int depthleft = 1;
        int depthright = 1;
        depthleft = 1 + TreeDepth(root.left);
        depthright = 1 + TreeDepth(root.right);
        return depthleft>depthright?depthleft:depthright;
    }
}
	 */
}
