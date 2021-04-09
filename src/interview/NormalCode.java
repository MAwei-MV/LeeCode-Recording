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
		//regex -- ������ʽ�ָ�����limit -- �ָ�ķ�����
		//���ո�s.split(" ");  . �� $�� | �� * ��ת���ַ�������ü� \\��
		//����ָ����������� | ��Ϊ���ӷ�
		s=s.replaceAll(" +","");
		System.out.println(s);
		String str[]=s.split("hei");
		//String.trim()��
		//��ȥ����ֻ��String��β�ո��ڲ�������
		//str.replace(" ", ����)��
		//ȥ�����пո񣬰�����β���м䣬�����ֽ���������һ���ո�
		//str.replaceAll(" +","") ��
		//����ƥ��ȥ�����пո�
		
		 for(String s1:str) { System.out.println(s1); }
		 
	}

	// ������������ݽ�һ����
	public static TreeNode1 buildNode(String[] arr, int index) {
		if (index >= arr.length || arr[index].equals("null")) {
			return null;
		}
		TreeNode1 root = new TreeNode1(Integer.parseInt(arr[index]));
		root.left = buildNode(arr, index * 2 + 1);
		root.right = buildNode(arr, index * 2 + 2);
		return root;
	}
	//����comparator�Ƚ�
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
