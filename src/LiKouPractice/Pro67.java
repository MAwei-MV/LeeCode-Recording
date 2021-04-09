package LiKouPractice;
import java.util.Stack;
public class Pro67 {
	public String addBinary(String a, String b) {
		int flag = 0;// 进位标志
		Stack<Integer> stack = new Stack<>();
		char[] c1 = a.toCharArray();
		char[] c2 = b.toCharArray();
		int i = c1.length - 1;
		int j = c2.length - 1;
		while (i >= 0 || j >= 0) {
			int value1 = (int)((i >= 0 ? c1[i] : '0'))-(int)('0');
			int value2 = (int)(j >= 0 ? c2[j] : '0')-(int)('0');
			stack.push((value1 ^ value2 + flag)%2);
			if (value1+value2+flag>=2)
				flag = 1;
			else flag=0;
			i--;
			j--;
		}
		if (flag == 1)
			stack.push(1);
		StringBuffer sb = new StringBuffer();
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.toString();
	}
}
