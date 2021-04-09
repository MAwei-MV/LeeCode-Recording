package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class NormalCode {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		s=s.substring(1, s.length()-1);
		//public String[] split(String regex, int limit)
		//regex -- 正则表达式分隔符。limit -- 分割的份数。
		//按空格：s.split(" ");  . 、 $、 | 和 * 等转义字符，必须得加 \\。
		//多个分隔符，可以用 | 作为连接符
		s=s.replaceAll(" +","");
		System.out.println(s);
		String str[]=s.split("hei");
		//String.trim()：
		//它去掉的只是String首尾空格，内部不处理；
		//str.replace(" ", “”)：
		//去掉所有空格，包括首尾、中间，但是又仅仅局限于一个空格
		//str.replaceAll(" +","") ：
		//可以匹配去掉所有空格
		
		 for(String s1:str) { System.out.println(s1); }
		 
	}

	// 根据输入的数据建一棵树
	public static TreeNode1 buildNode(String[] arr, int index) {
		if (index >= arr.length || arr[index].equals("null")) {
			return null;
		}
		TreeNode1 root = new TreeNode1(Integer.parseInt(arr[index]));
		root.left = buildNode(arr, index * 2 + 1);
		root.right = buildNode(arr, index * 2 + 2);
		return root;
	}
	//利用comparator比较
	public static void sortByComparator(int points[][],ArrayList<TreeNode1> LNode) {
	Arrays.sort(points, new Comparator<int[]>() {
		@Override
		public int compare(int[] o1, int[] o2) {
			if (o1[1] > o2[1]) {
				return 1;
			} else if (o1[1] < o2[1]) {
				return -1;
			} else {
				return 0;
			}
		}
	});
	Collections.sort(LNode, new Comparator<TreeNode1>(){
		@Override
		public int compare(TreeNode1 o1, TreeNode1 o2) {
			if(o1.val-o2.val>0)
				return 1;
			else {
				return -1;
			}
		}
		
	});
}
}
class TreeNode1 {
	TreeNode1 left;
	TreeNode1 right;
	int val;

	public TreeNode1(int val) {
		this.val = val;
	}
}
