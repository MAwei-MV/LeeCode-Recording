package interview;

public class JZ23 {
	public boolean VerifySquenceOfBST(int[] sequence) {
		int len = sequence.length;
		if (len <= 1) {
			return len==0?false:true;
		}
		return helper(sequence, 0, len - 1);
	}

	private boolean helper(int[] sequence, int start, int end) {
		if (end <= start)
			return true;
		int flag = sequence[end];
		int index = start;
		for (; index < end; index++) {
			if (sequence[index] == flag) {
				return false;
			}
			if (sequence[index] > flag) {
				break;
			}
		}
		for (int i = index + 1; i < end; i++) {
			if (sequence[i] < flag)
				return false;
		}
		return helper(sequence, start, index - 1) & helper(sequence, index, end-1);
	}

	class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;

		public TreeNode(int val) {
			this.val = val;
		}
	}
}
