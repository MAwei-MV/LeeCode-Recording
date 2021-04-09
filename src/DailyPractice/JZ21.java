package DailyPractice;

import java.util.Stack;

//æ≠µ‰Ã‚
public class JZ21 {
	public boolean IsPopOrder(int[] pushA, int[] popA) {
		Stack<Integer> stack = new Stack<>();
		int p = 0;
		for (int i = 0; i < pushA.length; i++) {
			stack.push(pushA[i]);
			while(!stack.isEmpty() && stack.peek() == popA[p]) {
				stack.pop();
				p++;
			}
		}
		return p == popA.length;
	}
}
