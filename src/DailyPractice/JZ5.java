package DailyPractice;

import java.util.Scanner;
import java.util.Stack;

public class JZ5 {
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();
	public static void main(String args[]) {
		int m,n=0;
		JZ5 j=new JZ5();
		Scanner sc=new Scanner(System.in);
		String initStr = sc.nextLine();
		String handleStr1 = initStr.substring(1, initStr.length() - 1);
		String[] handleStr2=handleStr1.split(",");
		for(int i =0;i<handleStr2.length;i++) {
			if(handleStr2[i].length()==5) {
				n++;
				if(n==1) {
					System.out.print(j.pop());	
				}
				else {
					System.out.print(","+j.pop());	
				}
			}
			else {
				String handleStr3 = handleStr2[i].substring(4,handleStr2[i].length()-1);
				m=Integer.parseInt(handleStr3);
				j.push(m);
			}
		}
	}
	public void push(int node) {
		stack1.push(node);
	}
	public int pop() {
		int temp = 0;
		if(stack2.isEmpty()) {
		while(!stack1.isEmpty()) {
				temp = stack1.pop();
				stack2.push(temp);
		}
		}
		return stack2.pop();
	}
}
