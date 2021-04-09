package LiKouPractice;

public class Pro150 {
	public int evalRPN(String[] tokens) {
		int index=0;
		int numArr[] = new int[tokens.length / 2 + 1];
		for (String s : tokens) {
			switch (s) {
			case "+":
				numArr[index-2]+=numArr[--index];
				break;
			case "-":
				numArr[index-2]-=numArr[--index];
				break;
			case "*":
				numArr[index-2]*=numArr[--index];
				break;
			case "/":
				numArr[index-2]/=numArr[--index];
				break;
			default:
				numArr[index++]=Integer.parseInt(s);
				break;
			}
		}
		return numArr [0];
	}
}
