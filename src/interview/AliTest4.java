package interview;

import java.util.Scanner;

import org.omg.CORBA.PUBLIC_MEMBER;

public class AliTest4 {
	public static void main(String args[]) {
		AliTest4 ali=new AliTest4();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		int[] val = new int[n];
		for (int i = 0; i < n; i++) {
			val[i] = sc.nextInt();
		}
		sc.nextLine();
		int pre[] = new int[n];
		for (int i = 0; i < n; i++) {
			pre[i] = sc.nextInt();
		}
		sc.nextLine();
		int mid[] = new int[n];
		for (int i = 0; i < n; i++) {
			mid[i] = sc.nextInt();
		}
		TreeNode head = ali.buildTree(val,pre,0,n-1,mid,0,n-1);
		
	}

public  TreeNode buildTree(int[] val, int[] pre,int start1,int end1, int[] mid,int start2,int end2) {
		if(start1>end1||start2>end2) {
			return null;
		}
		if(start1==end1) {
			return new TreeNode(val[pre[start1]]);
		}
		TreeNode node=new TreeNode(val[pre[start1]]);
		int index=start2;
		for(;index<end2;index++) {
			if(mid[index]==pre[start1])
			break;
		}
		node.left=buildTree(val, pre, start1+1,start1+index-start2 , mid, start2, index-1);
		node.left=buildTree(val, pre,start1+index-start2+1,end1 , mid, index+1, end2);
		return node;
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int val) {
			this.val = val;
		}
	}
}
