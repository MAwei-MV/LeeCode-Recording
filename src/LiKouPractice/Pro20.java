package LiKouPractice;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Pro20 {
	public static void main(String args[]) {
		Pro20 p =new Pro20();
		System.out.println(p.isValid("()"));
	}
	public boolean isValid(String s) {
		if (s.isEmpty())
			return true;
		Map<Character, Character> map = new HashMap<Character, Character>() {
			{
				put('}', '{');
				put(']', '[');
				put(')', '(');
			}
		};
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(' || c == '[' || c == '{')
				stack.push(c);
			else {
				if (stack.isEmpty()||map.get(c) != stack.peek() ) {
					return false;
				}
				stack.pop();
			}
		}
		if (stack.empty())
			return true;
		return false;
	}
}
